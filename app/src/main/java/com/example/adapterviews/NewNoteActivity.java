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

        Toast.makeText(this, "new note activity", Toast.LENGTH_SHORT).show();

        final EditText editText = new EditText(this);
        editText.setHint("Title");
        editText.setWidth(700);
        //editText.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));


        GridLayout gridLayout = findViewById(R.id.newNoteLayout);
        gridLayout.setColumnCount(2);
        gridLayout.setRowCount(2);

        gridLayout.addView(editText);

        final EditText notesBody = new EditText(this);
        notesBody.setHint("Content");
       gridLayout.addView(notesBody);

        final Spinner spinner = new Spinner(this);
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
                Intent intent = new Intent(NewNoteActivity.this, GridLayoutActivity.class);
                intent.putExtra("title", editText.getText().toString());
                intent.putExtra("body", notesBody.getText().toString());
                intent.putExtra("spinner", spinner.getSelectedItem().toString());
                startActivity(intent);
            }
        });
    }
}
