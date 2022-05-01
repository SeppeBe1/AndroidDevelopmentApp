package com.example.switcher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button voorkantBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        voorkantBtn = this.findViewById(R.id.voorButton);
        voorkantBtn.setOnClickListener(view -> {

            Intent envelop = new Intent(this, ReturnActivity.class);
            startActivity(envelop);
            onPause();
        }
        );
    }

    @Override
    public Bundle saveState() {
        Bundle bundle = new Bundle();
        bundle.putString(QUERY, query);
        return bundle;
    }

}