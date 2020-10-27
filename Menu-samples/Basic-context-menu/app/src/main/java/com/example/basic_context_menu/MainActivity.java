package com.example.basic_context_menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);

        //Give our button a context menu, let's do it
        registerForContextMenu(button);

    }

    //Override the register above with our own options
    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, view, menuInfo);
        menu.setHeaderTitle("Choose one please:");

        //Adding options
        menu.add(0, view.getId(), 0, "Upload");
        menu.add(0, view.getId(), 0, "Share");
        menu.add(0, view.getId(), 0, "Bookmark");
    }

    //make toast for each of selector
    @Override
    public boolean onContextItemSelected(MenuItem item){
        if(item.getTitle().equals("Upload")){
            Toast.makeText(this, "Uploaded", Toast.LENGTH_SHORT).show();
        }

        else if(item.getTitle().equals("Share")){
            Toast.makeText(this, "Shared!", Toast.LENGTH_SHORT).show();
        }

        else if(item.getTitle().equals("Bookmark")){
            Toast.makeText(this, "Put a bookmark", Toast.LENGTH_SHORT).show();
        }

        return true;
    }
}