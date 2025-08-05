package com.example.class_project1;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    MaterialButton icon1, icon2, icon3;
    TextInputEditText Name, PhoneNumber,Message,WebPage;
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

        icon1 = findViewById(R.id.iconButton);
        icon2 = findViewById(R.id.iconButton2);
        icon3 = findViewById(R.id.iconButton3);
        Name = findViewById(R.id.name);
        PhoneNumber = findViewById(R.id.phoneNumber);
        Message = findViewById(R.id.message);
        WebPage = findViewById(R.id.webpage);
        icon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, MainActivity2.class);
                intent.putExtra("name",Name.getText().toString());
                intent.putExtra("phoneNumber",PhoneNumber.getText().toString());
                intent.putExtra("message",Message.getText().toString());
                intent.putExtra("webPage",WebPage.getText().toString());
                ColorStateList iconTint = icon1.getIconTint();
                intent.putExtra("color", iconTint);
                try{
                    startActivity(intent);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }
        });
        icon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, MainActivity2.class);
                intent.putExtra("name",Name.getText().toString());
                intent.putExtra("phoneNumber",PhoneNumber.getText().toString());
                intent.putExtra("message",Message.getText().toString());
                intent.putExtra("webPage",WebPage.getText().toString());
                ColorStateList iconTint = icon2.getIconTint();
                intent.putExtra("color", iconTint);
                try{
                    startActivity(intent);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }
        });
        icon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, MainActivity2.class);
                intent.putExtra("name",Name.getText().toString());
                intent.putExtra("phoneNumber",PhoneNumber.getText().toString());
                intent.putExtra("message",Message.getText().toString());
                intent.putExtra("webPage",WebPage.getText().toString());
                ColorStateList iconTint = icon3.getIconTint();
                intent.putExtra("color", iconTint);
                try{
                    startActivity(intent);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }
        });
    }
}