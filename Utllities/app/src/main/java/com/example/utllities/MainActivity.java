package com.example.utllities;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.materialswitch.MaterialSwitch;
import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity extends AppCompatActivity {
    Button bluetoothBtn, wifiBtn, locationBtn;
    int BLUETOOTH_RESULT_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    bluetoothBtn = findViewById(R.id.bluetooth);
    wifiBtn = findViewById(R.id.wifi);

    // toggling wifi
    wifiBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            LayoutInflater layoutInflater = getLayoutInflater();
            View dialogView = layoutInflater.inflate(R.layout.dialog_switch, null);
            MaterialSwitch switchMaterial = dialogView.findViewById(R.id.toggle_switch);
            WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
            boolean isEnabled =  wifi.isWifiEnabled();
            MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(MainActivity.this).setTitle("WI-FI").setView(dialogView).setPositiveButton("Ok", null);
            alertDialogBuilder.show();
            switchMaterial.setText("Enable Wi-fi");
            if (isEnabled){
                switchMaterial.setChecked(true);
                switchMaterial.setText("Diable Wi-fi");
            }

            switchMaterial.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                    if (!isEnabled && isChecked){

                        startActivity(new Intent(Settings.Panel.ACTION_WIFI));
                    }
                    else if (isEnabled && !isChecked){

                        startActivity(new Intent(Settings.Panel.ACTION_WIFI));
                    }

                }
            });


        }
    });

    // toggling bluetooth
    bluetoothBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            BluetoothManager bluetoothManager = getSystemService(BluetoothManager.class);
            BluetoothAdapter bluetoothAdapter = bluetoothManager.getAdapter();
            LayoutInflater layoutInflater = getLayoutInflater();
            View dialogView = layoutInflater.inflate(R.layout.dialog_switch, null);
            MaterialSwitch switchMaterial = dialogView.findViewById(R.id.toggle_switch);
            if (bluetoothAdapter.isEnabled()){
                switchMaterial.setChecked(true);
                switchMaterial.setText("Disable Bluetooth");
            }
            MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(MainActivity.this).setTitle("Bluetooth").setView(dialogView).setPositiveButton("Ok", null);
            alertDialogBuilder.show();

            switchMaterial.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                    if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {

                        switchMaterial.setOnCheckedChangeListener(null);
                        switchMaterial.setChecked(!isChecked);
                        switchMaterial.setOnCheckedChangeListener(this);
                        return;
                    }
                    if (isChecked && !bluetoothAdapter.isEnabled()){
                        Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                        startActivityForResult(enableBtIntent, 1);
                    }
                    else if(!isChecked){
                        Toast.makeText(MainActivity.this, "Please disable manually", Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }
    });


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults, int deviceId) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults, deviceId);
        if (requestCode == BLUETOOTH_RESULT_CODE){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Please provide permission", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Bluetooth enabled", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Bluetooth not enabled", Toast.LENGTH_SHORT).show();
            }
        }

    }
}