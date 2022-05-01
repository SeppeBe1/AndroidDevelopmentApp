package com.example.recept;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Integer persons = 2;
    TextView personsTv;

    TextView ing1Tv;
    TextView ing2Tv;
    TextView ing3Tv;

    Button minBtn;
    Button plusBtn;

    Ingrediënt ingrediënts[] = {
            new Ingrediënt("Ei",1,""),
            new Ingrediënt("Bloem",250,"g"),
            new Ingrediënt("Melk",50,"dl"),
    };



    Ingrediënt ei = new Ingrediënt("Ei",1,"");
    Ingrediënt bloem = new Ingrediënt("Bloem",250,"g");
    Ingrediënt melk = new Ingrediënt("Melk",50,"dl");



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
//            -----------eieren----------
            float aantalEieren = ei.getAmount();
            aantalEieren--;
            ei.setAmount(aantalEieren);
//            -----------bloem----------
            float aantalBloem = bloem.getAmount();
            aantalBloem-=250;
            bloem.setAmount(aantalBloem);
//            -----------melk----------
            float aantalMelk = melk.getAmount();
            aantalMelk-=50;
            melk.setAmount(aantalMelk);
            update();

        });

        plusBtn.setOnClickListener(view -> {
            persons+=2;
//            -----------eieren----------
            float aantalEieren = ei.getAmount();
            aantalEieren++;
            ei.setAmount(aantalEieren);
//            -----------bloem----------
            float aantalBloem = bloem.getAmount();
            aantalBloem+=250;
            bloem.setAmount(aantalBloem);
//            -----------melk----------
            float aantalMelk = melk.getAmount();
            aantalMelk+=50;
            melk.setAmount(aantalMelk);
            update();
        });
    }

    void update(){
        personsTv.setText(String.format("Pannekoeken voor %d personen", persons));
        ing1Tv.setText(String.format("Eieren %.0f ", ei.getAmount() ));
        if(bloem.getAmount() >999){
            ing2Tv.setText(String.format(" bloem %.2fkg ", bloem.getAmount() / 1000));
        } else {
            ing2Tv.setText(String.format(" Bloem %.0f %s ", bloem.getAmount(),bloem.getUnit()));
        }

        if(melk.getAmount() >9){
            ing3Tv.setText(String.format(" melk %.0fl ", melk.getAmount() / 10));
        } else {
            ing3Tv.setText(String.format(" melk %.0f %s ", melk.getAmount(),melk.getUnit()));
        }
        minBtn.setEnabled(persons > 0);
    }
}