package com.example.registrationform;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView nameText, phoneText, cityText, genderText;
        String name, phone, city, gender;
        nameText = findViewById(R.id.name);
        phoneText = findViewById(R.id.phone);
        cityText = findViewById(R.id.City);
        genderText = findViewById(R.id.Gender);
        Intent intent = getIntent();
        SharedPreferences sharedPrefs = getSharedPreferences("userPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        name = sharedPrefs.getString("username", "");
        if (!name.isEmpty()){
            // if user is already registered
            phone = sharedPrefs.getString("phone", "");
            city = sharedPrefs.getString("city", "");
            gender = sharedPrefs.getString("gender", "");
        } else {
            // if user comes from the signup page
            name = intent.getStringExtra("name");
            phone = intent.getStringExtra("phone");
            city = intent.getStringExtra("city");
            gender = intent.getStringExtra("gender");
        }
        nameText.setText(name);
        Log.d("00000000----00000000", "onCreate: " + name);
        phoneText.setText(phone);
        cityText.setText(city);
        genderText.setText(gender);


    }
}