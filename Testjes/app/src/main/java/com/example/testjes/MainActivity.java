package com.example.testjes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv_hello = findViewById(R.id.hello);
        Button speech = findViewById(R.id.buttonSpeech);
        textToSpeech = new TextToSpeech(this,this);

        speech.setOnClickListener(view ->{
            String text = tv_hello.getText().toString();
            textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
        } );
    }
    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int result = textToSpeech.setLanguage(Locale.US);
        }
    }

}