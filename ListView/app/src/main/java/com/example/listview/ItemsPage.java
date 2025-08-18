package com.example.listview;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class ItemsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_items_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView tv = findViewById(R.id.textview);
        TextView heading = findViewById(R.id.heading);
        Intent intent = getIntent();
            String[] items = intent.getStringArrayExtra("fruit");
            String selectedFruit = intent.getStringExtra("SelectedFruit");
            heading.setText("Items that can be made with " + selectedFruit);
        for (String item: items) {
            tv.setText(tv.getText() + item + '\n');
        }

    }
}