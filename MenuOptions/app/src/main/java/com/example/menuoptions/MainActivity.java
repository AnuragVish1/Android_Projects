package com.example.menuoptions;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.item1){
            Toast.makeText(this, "Item 1 selected", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, Settings.class);
            startActivity(intent);
        } else if (id == R.id.item2) {
            Toast.makeText(this, "Item 2 selected", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.item3) {
            Toast.makeText(this, "Item 3 selected", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.item3_1) {
            Toast.makeText(this, "Item 1 of Item_3 selected", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.item3_2) {
            Toast.makeText(this, "Item 2 of Item_3 selected", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, PolicyPage.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
