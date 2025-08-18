package com.example.listview;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

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

        ListView listview;
        listview = findViewById(R.id.listview);
        String[] content = {"Mango","Apple","Banana","Guava", "Pineapple"};

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this,R.layout.listview, R.id.textview, content);
        listview.setAdapter(arrayAdapter);
        String[][] fruits = {
                {"mango", "mango smoothie", "mango ice cream", "mango salsa", "mango lassi"},
                {"apple", "apple pie", "apple juice", "apple sauce", "apple chips"},
                {"banana", "banana bread", "banana smoothie", "banana pancakes", "banana split"},
                {"guava", "guava juice", "guava jam", "guava pastry", "guava salad"},
                {"pineapple", "pineapple pizza", "pineapple juice", "pineapple upside-down cake", "grilled pineapple"}
        };
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("Item", "onItemClick: " + position);
                String selectedFruit = content[position];
                Intent intent = new Intent(MainActivity.this,  ItemsPage.class);
                intent.putExtra("fruit", fruits[position]);
                intent.putExtra("SelectedFruit", content[position]);
                startActivity(intent);
            }
        });


    }
}