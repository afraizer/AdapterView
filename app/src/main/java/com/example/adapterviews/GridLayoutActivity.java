package com.example.adapterviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GridLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout);

        Toast.makeText(this, "grid activity", Toast.LENGTH_SHORT).show();
        Intent intent2 = getIntent();
        if (intent2 != null) {
            final String noteTitle = intent2.getStringExtra("title");
            final String noteBody = intent2.getStringExtra("body");
            final String spinnerSelction = intent2.getStringExtra("spinner");

            ListView listView = new ListView(this);
            setContentView(listView);
            List<String> notes = new ArrayList<>();
            List<String> notePage = new ArrayList<>();
            notes.add(noteTitle);
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1,
                    notePage);
            listView.setAdapter(arrayAdapter);
            Toast.makeText(this, noteTitle, Toast.LENGTH_SHORT).show();
        }
    }
}
