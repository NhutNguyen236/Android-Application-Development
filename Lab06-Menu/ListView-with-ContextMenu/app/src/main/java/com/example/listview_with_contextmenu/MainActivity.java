package com.example.listview_with_contextmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String animals[] = {"Dog","Cat","Dolphin","Bird","Fish"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,animals);
        listView.setAdapter(adapter);

        //Register listView for ContextMenu, still the same right
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        // Get the info on which item was selected
        AdapterView.AdapterContextMenuInfo index = (AdapterView.AdapterContextMenuInfo) menuInfo;

        String animal = ((TextView)index.targetView).getText().toString();

        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_layout,menu);
        menu.setHeaderTitle("Name is: " + animal);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item){

        AdapterView.AdapterContextMenuInfo index = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        Object obj = listView.getItemAtPosition(index.position);

        String animal = obj.toString();

        if(item.getItemId()==R.id.four){
            Toast.makeText(getApplicationContext(),animal  + " has 4 legs",Toast.LENGTH_LONG).show();
        }
        
        else if(item.getItemId()==R.id.two){
            Toast.makeText(getApplicationContext(),animal + " has 2 legs",Toast.LENGTH_LONG).show();
        }

        else if(item.getItemId()==R.id.zero){
            Toast.makeText(getApplicationContext(),animal + " has no legs at all",Toast.LENGTH_LONG).show();
        }
        
        else{
            return false;
        }
        
        return true;
    }
}
