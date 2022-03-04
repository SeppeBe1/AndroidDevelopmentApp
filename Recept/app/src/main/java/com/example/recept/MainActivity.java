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
    Integer bloem = 250;
    Integer melk = 25;

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
            melk-=25;
            update();

        });

        plusBtn.setOnClickListener(view -> {
            persons+=2;
            ei++;
            bloem+=250;
            melk+=25;
            update();
        });
    }

    void update(){
        personsTv.setText(String.format("Recept voor %d personen", persons));
        ing1Tv.setText(String.format("Eieren %d ", ei));
        ing2Tv.setText(String.format(" bloem %dg ", bloem));
        ing3Tv.setText(String.format(" %ddl ", melk));

        minBtn.setEnabled(persons > 0);
    }
}