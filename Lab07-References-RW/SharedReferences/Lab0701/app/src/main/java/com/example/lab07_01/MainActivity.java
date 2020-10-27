package com.example.lab07_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SeekBar seekbar1, seekbar2;
    private RadioButton radio1, radio2, radio3;
    private Button button;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get ID for seekbars
        seekbar1 = (SeekBar)findViewById(R.id.seekbar1);
        seekbar2 = (SeekBar)findViewById(R.id.seekbar2);

        //Get ID for radioButton
        radio1 = (RadioButton)findViewById(R.id.back1);
        radio2 = (RadioButton)findViewById(R.id.back2);
        radio3 = (RadioButton)findViewById(R.id.back3);

        //Get ID for Button
        button = (Button)findViewById(R.id.onlyButton);

        //Get ID for RadioGroup
        radioGroup = (RadioGroup)findViewById(R.id.backgroudColor);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.doSave(view);
            }
        });

        this.loadGameSetting();
    }

    private void loadGameSetting()  {
        SharedPreferences sharedPreferences= this.getSharedPreferences("appSetting", Context.MODE_PRIVATE);

        if(sharedPreferences!= null) {

            int brightness = sharedPreferences.getInt("first setting", 90);
            int sound = sharedPreferences.getInt("second setting",95);
            int checkedRadioButtonId = sharedPreferences.getInt("color change", R.id.back2);

            this.seekbar1.setProgress(sound);
            this.seekbar2.setProgress(brightness);
            this.radioGroup.check(checkedRadioButtonId);
        }

        else {
            this.radioGroup.check(R.id.back2);
            Toast.makeText(this,"Use the default game setting",Toast.LENGTH_LONG).show();
        }

    }

    public void doSave(View view){

        SharedPreferences sharedPreferences = this.getSharedPreferences("appSetting", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        //Put in setting to the editor
        editor.putInt("first setting", this.seekbar1.getProgress());
        editor.putInt("second setting", this.seekbar2.getProgress());

        //Get check radio button id
        int checkedRadioButton = radioGroup.getCheckedRadioButtonId();

        editor.putInt("color change", checkedRadioButton);

        editor.apply();

        Toast.makeText(this, "Setting Saved", Toast.LENGTH_SHORT).show();
    }
}