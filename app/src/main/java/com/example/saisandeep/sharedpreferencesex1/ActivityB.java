package com.example.saisandeep.sharedpreferencesex1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by saisandeep on 3/16/2015.
 */
public class ActivityB extends Activity {

    public static final String DEFAULT="N/A";
    Button load,previous;
    TextView usernameRetreive,passwordRetreive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityb);
        load= (Button) findViewById(R.id.button3);
        previous= (Button) findViewById(R.id.button4);
        usernameRetreive= (TextView) findViewById(R.id.textView4);
        passwordRetreive= (TextView) findViewById(R.id.textView6);
    }

    public void load(View v)
    {
        SharedPreferences sp=getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String user=sp.getString("usernamedata", DEFAULT);
        String pass=sp.getString("passworddata",DEFAULT);

        if(user.equals(DEFAULT) || pass.equals(DEFAULT))
        {
            Toast.makeText(this,"Data was not loaded",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"Data was loaded successfully",Toast.LENGTH_SHORT).show();
            usernameRetreive.setText(user);
            passwordRetreive.setText(pass);
        }
    }

    public void previous(View v)
    {

        Intent in=new Intent(this,MainActivity.class);
        startActivity(in);
    }

}
