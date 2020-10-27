package com.example.simple_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get listView ID from xml
        listView = (ListView)findViewById(R.id.listView);

        //Make an array of things that will be in listView
        String[] animals = new String[]{
                "Dog", "Cat", "Tiger",
                "Fish","Elephant","Zebra",
                "Lion","Dolphin"
        };

        /*Define a new Adapter
        First parameter - Context
        Second parameter - Layout for the row
        Third parameter - ID of the TextView to which the data is written
        Forth - the Array of data*/

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_2,android.R.id.text1,animals);

        //Assign adapter to ListView
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                //Animal index in the array created above
                int animal_position = position;

                String animal = (String)listView.getItemAtPosition(animal_position);

                Toast.makeText(getApplicationContext(),"Position number " + (animal_position + 1) + " is " + animal, Toast.LENGTH_SHORT).show();
            }
        });

    }
}