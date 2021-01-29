package com.example.project1_calculator_image;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TamagoActivity extends AppCompatActivity {


    TextView text;
    ImageView egg;
    int num;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tamago);


        egg = (ImageView) findViewById(R.id.egg);
        text = (TextView) findViewById(R.id.text);

        egg.setOnClickListener(view -> {click();});

    }

    private void click(){

        num += 1;

        if(num < 10){
            text.setText(String.valueOf(num));
        }
        else{
            text.setText("Hit!!");
            Toast.makeText(getApplicationContext(), "Success!", Toast.LENGTH_LONG).show();
            num = 0;
        }

    }





}




