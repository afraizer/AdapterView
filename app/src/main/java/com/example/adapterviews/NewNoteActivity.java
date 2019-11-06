package com.example.adapterviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class NewNoteActivity extends AppCompatActivity {
    static final int LOGIN_REQUEST_CODE = 1; // identifies a request for a result

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);


        final EditText editText = new EditText(this);
        editText.setHint("Title");
        editText.setWidth(700);
        //editText.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));


        GridLayout gridLayout = findViewById(R.id.newNoteLayout);
        gridLayout.setColumnCount(2);
        gridLayout.setRowCount(2);

        gridLayout.addView(editText);

        EditText notesBody = new EditText(this);
        notesBody.setHint("Content");
        //notesBody.setLayoutParams(new GridLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        //editText.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        gridLayout.addView(notesBody);

        Spinner spinner = new Spinner(this);
        String[] spinnerArray = new String[] {"Work", "Personal"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        gridLayout.addView(spinner);


        Button backButton = new Button(this);
        backButton.setText("Back");
        gridLayout.addView(backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("title", editText.getText().toString());
                NewNoteActivity.this.finish();
            }
        });
    }
}
