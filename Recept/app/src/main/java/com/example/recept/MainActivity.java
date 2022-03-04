package com.example.recept;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Integer persons = 2;
    TextView personsTv;

    TextView ing1Tv;
    TextView ing2Tv;
    TextView ing3Tv;

    Integer ei = 1;
    double bloem = 250;
    double melk = 50;

    Button minBtn;
    Button plusBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personsTv = findViewById(R.id.persons);

        ing1Tv = findViewById(R.id.ingredient1);
        ing2Tv= findViewById(R.id.ingredient2);
        ing3Tv = findViewById(R.id.ingredient3);

        minBtn = findViewById(R.id.minusBtn);
        plusBtn = findViewById(R.id.plusBtn);
        update();

        minBtn.setOnClickListener(view -> {
            persons-=2;
            ei--;
            bloem-=250;
            melk-=50;
            update();

        });

        plusBtn.setOnClickListener(view -> {
            persons+=2;
            ei++;
            bloem+=250;
            melk+=50;
            update();
        });
    }

    void update(){
        personsTv.setText(String.format("Pannekoeken voor %d personen", persons));
        ing1Tv.setText(String.format("Eieren %d ", ei));
        if(bloem >999){
            ing2Tv.setText(String.format(" bloem %.2fkg ", bloem / 1000 ));
        } else {
            ing2Tv.setText(String.format(" Bloem %.0fg ", bloem));
        }
        ing3Tv.setText(String.format("Melk %.2fl ", melk / 10));

        minBtn.setEnabled(persons > 0);
    }
}