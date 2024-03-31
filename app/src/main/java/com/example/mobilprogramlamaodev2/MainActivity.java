package com.example.mobilprogramlamaodev2;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int randomNumber;
    private EditText guessEditText;
    private TextView resultTextView;
    private Button playAgainButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        guessEditText = findViewById(R.id.guessEditText);
        resultTextView = findViewById(R.id.resultTextView);
        playAgainButton = findViewById(R.id.playAgainButton);

        Button guessButton = findViewById(R.id.guessButton);
        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkGuess();
            }
        });


        playAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartGame();
            }
        });


        generateRandomNumber();
    }

    private void generateRandomNumber() {
        Random random = new Random();
        randomNumber = random.nextInt(100) + 1;
    }

    private void checkGuess() {
        String guessString = guessEditText.getText().toString().trim();
        if (!guessString.isEmpty()) {
            int guess = Integer.parseInt(guessString);
            if (guess == randomNumber) {
                resultTextView.setText("Tebrikler Doğru Sayıyı Tahmin Ettiniz");
                playAgainButton.setVisibility(View.VISIBLE);
            } else if (guess < randomNumber) {
                resultTextView.setText("Daha Yüksek Bir Sayı Deneyiniz");
            } else {
                resultTextView.setText("Daha Düşük Bir Sayı Deneyiniz");
            }
            guessEditText.setText("");
        }
    }


    private void restartGame() {
        generateRandomNumber();
        resultTextView.setText("");
        guessEditText.setText("");
        playAgainButton.setVisibility(View.GONE);
    }
}