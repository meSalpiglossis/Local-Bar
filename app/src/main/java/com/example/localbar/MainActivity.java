package com.example.localbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> drinksList = new ArrayList<>();
    private ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, drinksList);;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView drinkList = findViewById(R.id.drinkList);
        EditText editText = findViewById(R.id.editText);
        Button addButton = findViewById(R.id.addButton);

        drinkList.setAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String drinkName = editText.getText().toString();
                if (!drinkName.isEmpty()) {
                    drinksList.add(drinkName);
                    adapter.notifyDataSetChanged();
                    editText.setText("");
                }
            }
        });
    }
}