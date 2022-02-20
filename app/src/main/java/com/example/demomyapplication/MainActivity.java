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

        Button mijnKnop = findViewById(R.id.mijnButton);
        mijnKnop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView mijnTextView = findViewById(R.id.mijnTextView);
                mijnTextView.setText("Kaas");
            }
        });
    }
}