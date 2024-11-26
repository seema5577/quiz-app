package com.example.quizapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView resultTextView = findViewById(R.id.resultTextView);
        Button restartButton = findViewById(R.id.restartButton);

        int score = getIntent().getIntExtra("SCORE", 0);
        resultTextView.setText("Your Score: " + score);

        restartButton.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, LoginActivity.class);
            startActivity(intent);
        });
    }
}
