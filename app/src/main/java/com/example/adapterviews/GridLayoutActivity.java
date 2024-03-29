package com.example.adapterviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GridLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout);

        Toast.makeText(this, "Grid Layout", Toast.LENGTH_SHORT).show();
        GridLayout gridLayout = new GridLayout(this);
        gridLayout.setRowCount(2);

        Button addNewNote = new Button (this);
        addNewNote.setText("Add new note");
        addNewNote.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        gridLayout.addView(addNewNote);

        addNewNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GridLayoutActivity.this, NewNoteActivity.class);
                startActivity(intent);
            }
        });

        Intent intent2 = getIntent();
        if (intent2 != null) {
            final String noteTitle = intent2.getStringExtra("title");
            final String noteBody = intent2.getStringExtra("body");
            final String spinnerSelction = intent2.getStringExtra("spinner");

            ListView listView = new ListView(this);
            setContentView(listView);
            List<String> notePage = new ArrayList<>();
            notePage.add(noteTitle);

            // create an array adapter
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_activated_1,
                    notePage);
            listView.setAdapter(arrayAdapter);
            listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        }
    }
}
