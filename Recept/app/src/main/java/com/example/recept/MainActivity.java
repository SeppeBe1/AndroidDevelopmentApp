package com.example.recept;

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

        Integer persons = 2;
        TextView personsTv = findViewById(R.id.persons);

        TextView ing1Tv = findViewById(R.id.ingedient1);
        TextView ing2Tv= findViewById(R.id.ingedient2);
        TextView ing3Tv = findViewById(R.id.ingedient3);

        Integer ing1;
        Integer ing2;
        Integer ing3;

        Button minBtn = findViewById(R.id.minusBtn);
        Button plusBtn = findViewById(R.id.plusBtn);

        public void update(){



        }

        minBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                persons--;
                personsTv.setText();
                update();

            }
        });

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                persons++;

            }
        });

    }
}