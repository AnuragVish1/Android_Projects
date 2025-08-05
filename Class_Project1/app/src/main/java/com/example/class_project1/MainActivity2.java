package com.example.class_project1;
import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity2 extends AppCompatActivity {
MaterialButton phone, message, location, webpage;
    @SuppressLint({"ClickableViewAccessibility", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView tv = findViewById(R.id.textView2);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String phoneNumber = intent.getStringExtra("phoneNumber");
        String messageText = intent.getStringExtra("message");
        String webPageUrl = intent.getStringExtra("webPage");
        ColorStateList receivedColor = intent.getParcelableExtra("color");

        tv.setText("Hello " + name);
        phone = findViewById(R.id.phoneButton);
        message = findViewById(R.id.messageButton);
        webpage = findViewById(R.id.webpage);
        location = findViewById(R.id.location);

        phone.setIconTint(receivedColor);
        message.setIconTint(receivedColor);
        webpage.setIconTint(receivedColor);
        location.setIconTint(receivedColor);
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:" + phoneNumber));

                try {
                    startActivity(intent1);
                } catch (RuntimeException e) {
                    throw new RuntimeException(e);
                }

            }
        });

        phone.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Scale down when pressed
                        v.animate()
                                .scaleX(0.85f) // Scale to 95% of original size
                                .scaleY(0.85f)
                                .setDuration(300) // Animation duration in milliseconds
                                .start();
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL: // Handle cases where touch is cancelled
                        // Scale back up when released
                        v.animate()
                                .scaleX(1.0f) // Scale back to 100%
                                .scaleY(1.0f)
                                .setDuration(300) // Animation duration
                                .start();
                        break;
                }
                return false; // Important: return false so the regular OnClickListener can still be triggered
            }
        });

         message.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 try {
                     Intent intent = new Intent(Intent.ACTION_VIEW);
                     intent.setData(Uri.parse("smsto:" + phoneNumber));
                     intent.putExtra("sms_body", messageText);
                     startActivity(intent);
                 } catch (ActivityNotFoundException e) {
                     Toast.makeText(MainActivity2.this, "No messaging app found", Toast.LENGTH_SHORT).show();
                 }
             }
         });

         message.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 return false;
             }
         });

         webpage.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(webPageUrl));
                 startActivity(browserIntent);
             }
         });

         location.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 Intent mapIntent = new Intent(Intent.ACTION_VIEW);
                 mapIntent.setPackage("com.google.android.apps.maps");
                 startActivity(mapIntent);
             }
         });
    }
}