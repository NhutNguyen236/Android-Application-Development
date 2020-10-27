package com.example.alert_dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.alert_dialog.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private int index = -1;
    private Button button1;
    private Button button2;
    private Button button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.button1);
        button2 =(Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSimpleDialog();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSingeChoiceDialog();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMutipleChoiceDialog();
            }
        });

    }
    public void showSimpleDialog()
    {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        //Thiết lập tiêu đề
        b.setTitle("Task");
        b.setMessage("Dress up like Mario and throw mushrooms at people");
        // Nút Ok
        b.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(MainActivity.this, "You have selected the delete button", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        //Nút Cancel
        b.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        //Tạo dialog
        AlertDialog al = b.create();
        //Hiển thị
        al.show();
    }

    public void showSingeChoiceDialog(){
        //Items
        final String[] datas = {"Coca", "Pepsi","Sprite","Seven Up"};
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setSingleChoiceItems(datas, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                index = which;
            }
        });

        b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Toast.makeText(MainActivity.this, "You selected "+ datas[index] , Toast.LENGTH_SHORT).show();
            }
        });
        b.show();
    }



    public void showMutipleChoiceDialog() {
        final String[] animals = {"Fish", "Dog", "Cat"};
        final boolean[] selectedAnimals = new boolean[]{false,false,false};

        //convert selectedAnimals to List
        final List<String> animalList = Arrays.asList(animals);

        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setMultiChoiceItems(animals, null,new DialogInterface.OnMultiChoiceClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                //get selected item on checkList
                selectedAnimals[which] = isChecked;

                //get current focused item
                String currentAnimal = animalList.get(which);

            }
        });

        b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                //Initialize toast string
                String toast = "";
                ArrayList<String> checkedAnimals = new ArrayList<String>();
                for(int i = 0; i<selectedAnimals.length; i++){
                    boolean checked = selectedAnimals[i];
                    if (checked) {
                        checkedAnimals.add(animalList.get(i));
                    }
                }
                toast = "You have selected: " + checkedAnimals.toString();
                Toast.makeText(MainActivity.this, toast , Toast.LENGTH_SHORT).show();
            }
        });
        b.show();
    }
}
