package com.example.recept;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Integer persons = 2;
    TextView personsTv;

    TextView ing1Tv;
    TextView ing2Tv;
    TextView ing3Tv;

    Integer ing1;
    Integer ing2;
    Integer ing3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView personsTv = findViewById(R.id.persons);

        TextView ing1Tv = findViewById(R.id.ingedient1);
        TextView ing2Tv= findViewById(R.id.ingedient2);
        TextView ing3Tv = findViewById(R.id.ingedient3);

        Integer ing1;
        Integer ing2;
        Integer ing3;

        Button minBtn = findViewById(R.id.minusBtn);
        Button plusBtn = findViewById(R.id.plusBtn);
        update();

        minBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                persons--;
                update();

            }
        });

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                persons++;
                update();

            }
        });

    }
    void update(){
        personsTv.setText(String.format("Recept voor %d personen", persons));


    }
}