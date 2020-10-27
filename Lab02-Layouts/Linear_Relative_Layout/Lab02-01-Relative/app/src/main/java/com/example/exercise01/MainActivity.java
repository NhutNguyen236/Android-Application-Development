package com.example.exercise01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

/*Relative Layout
* Intent to start a new activity
* Transfer data from an activity to another using Bundle*/
public class MainActivity extends AppCompatActivity {

    private EditText userName_Input, passWord_Input;
    private TextView userName_text, passWord_text;
    private Button LogIn;
    private CheckBox Remember_pass;
    public final static String EXTRA_MESSAGE = "com.example.exercise01.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get ID for each components
        userName_Input = (EditText)findViewById(R.id.userName);
        passWord_Input = (EditText)findViewById(R.id.passWord);

        userName_text = (TextView)findViewById(R.id.userName_view);
        passWord_text = (TextView)findViewById(R.id.passWord_view);

        LogIn = (Button)findViewById(R.id.logIn);

        Remember_pass = (CheckBox)findViewById(R.id.checkBox);

        //Set onClickListener for Log-in button
        LogIn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                String user_name = userName_Input.getText().toString().trim().toLowerCase();

                //If both username and password are empty
                if(userName_Input.getText().toString().equals("") && passWord_Input.getText().toString().equals("")){
                    Toast.makeText(context, "Username and Password cannot be empty",Toast.LENGTH_SHORT).show();
                    userName_Input.requestFocus();
                }

                //If username is empty
                else if(userName_Input.getText().toString().equals("")){
                    Toast.makeText(context, "Please enter Username",Toast.LENGTH_SHORT).show();
                    userName_Input.requestFocus();
                }

                //If username is already in use
                else if(user_name.equals("admin")){
                    System.out.print("bad");
                    Toast.makeText(context, "Username is already used",Toast.LENGTH_SHORT).show();
                    userName_Input.requestFocus();
                }

                //If password is empty
                else if(passWord_Input.getText().toString().equals("")){
                    Toast.makeText(context,"Please enter Password",Toast.LENGTH_SHORT).show();
                    passWord_Input.requestFocus();
                }

                //if password's length is less than 6
                else if(passWord_Input.getText().toString().trim().length() < 6){
                    Toast.makeText(context, "Your password has less than 6 letters",Toast.LENGTH_SHORT).show();
                    passWord_Input.requestFocus();
                }

                else{
                    //Get value from userName and passWord
                    String username_mess = userName_Input.getText().toString().trim();
                    String password_mess = passWord_Input.getText().toString().trim();

                    Bundle bundle = new Bundle();
                    bundle.putString("username",username_mess);
                    bundle.putString("password",password_mess);

                    //I'm about to send username and password to second activity named AfterLogin
                    //Make a intent to got to the another activity
                    Intent intent = new Intent(MainActivity.this, AfterLogin.class);
                    intent.putExtras(bundle);

                    //Then start new activity
                    startActivity(intent);
                    Toast.makeText(context, "Successful Login",Toast.LENGTH_SHORT).show();
                }
            }

        });

        //Set onClickListener for remember password checkbox
        Remember_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                String pass_word = passWord_Input.getText().toString().trim().toLowerCase();

                //If password is empty so the app cannot remember your password
                if(pass_word.equals("")){
                    Toast.makeText(context, "Your password is Empty",Toast.LENGTH_SHORT).show();
                    passWord_Input.requestFocus();
                }

                //if password's length is less than 6
                else if(passWord_Input.getText().toString().trim().length() < 6){
                    Toast.makeText(context, "Your password has less than 6 letters",Toast.LENGTH_SHORT).show();
                    passWord_Input.requestFocus();
                }
				
				else{
					Toast.makeText(context, "Your password is remembered", Toast.LENGTH_SHORT).show();
				}
            }
        });
    }
}