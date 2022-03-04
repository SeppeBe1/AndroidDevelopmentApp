package com.example.demomyapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button minKnop = findViewById(R.id.minButton);
        minKnop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView mijnTextView = findViewById(R.id.mijnTextView);
                int getal = Integer.parseInt(mijnTextView.getText().toString());
                getal++;
                mijnTextView.setText(getal);
                if(getal < 2){
                    minKnop.setEnabled(false);
                } else {
                    minKnop.setEnabled(true);
                }
            }
        });

        Button plusKnop = findViewById(R.id.plusButton);
        plusKnop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView mijnTextView = findViewById(R.id.mijnTextView);
                int getal = Integer.parseInt(mijnTextView.getText().toString());
                getal--;
                mijnTextView.setText(getal);
                if(getal > 9){
                    plusKnop.setEnabled(false);
                } else {
                    plusKnop.setEnabled(true);
                }
            }
        });
    }
}