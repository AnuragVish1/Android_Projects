package com.example.registrationform;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignUpScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText name, phoneNumber, password;
        AutoCompleteTextView at;

        name = findViewById(R.id.textName);
        phoneNumber = findViewById(R.id.textNumber);
        password = findViewById(R.id.textPassword);
        final String[] gender = new String[1];
        final RadioButton[] rb = new RadioButton[1];
        at = findViewById(R.id.dropdownMenuAuto);
        RadioGroup rg = findViewById(R.id.radioGroup);
        int selectedId = rg.getCheckedRadioButtonId();
        if (selectedId != -1){
            rb[0] = findViewById(selectedId);
            gender[0] = rb[0].getText().toString();
        } else {
            gender[0] = "";
        }

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup group, int checkedId) {
                if (checkedId != 1){
                    RadioButton rb = findViewById(checkedId);
                     gender[0] = rb.getText().toString();
                }
            }
        });
        final String[] city = new String[1];
        Button signUpButton = findViewById(R.id.signUp);
        Button loginButton = findViewById(R.id.Login);

        at.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                city[0] = selectedItem;
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().isEmpty()){
                    Toast.makeText(SignUpScreen.this, "Please enter Name", Toast.LENGTH_SHORT).show();
                } else if (phoneNumber.getText().toString().isEmpty()) {
                    Toast.makeText(SignUpScreen.this, "Please enter Phone number", Toast.LENGTH_SHORT).show();
                } else if (password.getText().toString().isEmpty()) {
                    Toast.makeText(SignUpScreen.this, "Please enter Password", Toast.LENGTH_SHORT).show();
                } else if (password.getText().toString().length() != 8) {
                    Toast.makeText(SignUpScreen.this, "Password must be of 8 digit", Toast.LENGTH_SHORT).show();
                } else if (phoneNumber.getText().toString().length() != 10) {
                    Toast.makeText(SignUpScreen.this, "Please enter valid phone number", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(SignUpScreen.this, MainScreen.class);
                    intent.putExtra("name", name.getText().toString());
                    intent.putExtra("phone", phoneNumber.getText().toString());
                    intent.putExtra("password", password.getText().toString());
                    intent.putExtra("city", city[0]);
                    intent.putExtra("gender", gender[0]);
                    SharedPreferences sharedPrefs = getSharedPreferences("userPrefs", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPrefs.edit();
                    editor.putString("username", name.getText().toString());
                    editor.putString("phone", phoneNumber.getText().toString());
                    editor.putString("city", city[0]);
                    editor.putString("gender", gender[0]);
                    editor.apply();
                    startActivity(intent);
                }
            }
        });

    }


}