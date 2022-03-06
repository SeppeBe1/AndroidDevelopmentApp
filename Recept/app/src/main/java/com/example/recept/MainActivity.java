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

        Ingrediënt ei = new Ingrediënt("Ei",1,"");
        Ingrediënt bloem = new Ingrediënt("Bloem",250,"g");
        Ingrediënt melk = new Ingrediënt("Melk",50,"dl");
        update();

        minBtn.setOnClickListener(view -> {
            persons-=2;
//            -----------eieren----------
            double aantalEieren = ei.getAmount();
            aantalEieren--;
            ei.setAmount(aantalEieren);
//            -----------bloem----------
            double aantalBloem = bloem.getAmount();
            aantalBloem-=250;
            bloem.setAmount(aantalBloem);
//            -----------melk----------
            double aantalMelk = melk.getAmount();
            aantalMelk-=50;
            melk.setAmount(aantalMelk);
            update();

        });

        plusBtn.setOnClickListener(view -> {
            persons+=2;
//            -----------eieren----------
            double aantalEieren = ei.getAmount();
            aantalEieren++;
            ei.setAmount(aantalEieren);
//            -----------bloem----------
            double aantalBloem = bloem.getAmount();
            aantalBloem+=250;
            bloem.setAmount(aantalBloem);
//            -----------melk----------
            double aantalMelk = melk.getAmount();
            aantalMelk+=50;
            melk.setAmount(aantalMelk);
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