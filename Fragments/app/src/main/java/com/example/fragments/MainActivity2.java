package com.example.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainActivity2 extends AppCompatActivity {

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
 
        ListView listview;
        listview = findViewById(R.id.listView);
        String[] content = {"PORSCHE","BMW","CADILLAC"};
        String[] logos = {"porschelogo", "bmwlogopngtransparent", "cadillaclogo"};

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity2.this,R.layout.fragment_item, R.id.item_number, content);
        listview.setAdapter(arrayAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity2.this, "Hello" + position, Toast.LENGTH_SHORT).show();

                // setting text to fragment

                BlankFragment blankfrag = BlankFragment.newInstance(content[position]);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainerView, blankfrag)
                        .commit();

                BottomSheetDialog bottomSheet = new BottomSheetDialog(MainActivity2.this);
                View bottomSheetView = LayoutInflater.from(MainActivity2.this).inflate(R.layout.fragment_item_list_dialog_list_dialog, null);
//                TextView tv = bottomSheetView.findViewById(R.id.image);
                ImageView imv = bottomSheetView.findViewById(R.id.image);
                imv.setImageResource(R.drawable.bmwlogopngtransparent);
                int resourceId = getResources().getIdentifier(logos[position], "drawable", getPackageName());
                imv.setImageResource(resourceId);
                bottomSheet.setContentView(bottomSheetView);
                bottomSheet.show();
            }
        });

    }
}