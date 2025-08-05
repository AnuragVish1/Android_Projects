package com.example.registrationform;

import android.content.Intent;
import android.os.Bundle;
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
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String phoneNumber = intent.getStringExtra("phone");
        String city = intent.getStringExtra("city");
        String gender = intent.getStringExtra("gender");
        nameText = findViewById(R.id.name);
        phoneText = findViewById(R.id.phone);
        cityText = findViewById(R.id.City);
        genderText = findViewById(R.id.Gender);

        nameText.setText(name);
        phoneText.setText(phoneNumber);
        cityText.setText(city);
        genderText.setText(gender);

    }
}