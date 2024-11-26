package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    private TextView questionTextView;
    private RadioGroup optionsRadioGroup;
    public Button nextButton;

    public String[] questions = {
            "What is the capital of France?",
            "Who is the CEO of Tesla?",
            "What is 5 + 3?",
            "What is the largest planet in our solar system?"
    };

    public String[][] options = {
            {"Berlin", "Madrid", "Paris", "Rome"},
            {"Jeff Bezos", "Elon Musk", "Bill Gates", "Steve Jobs"},
            {"5", "8", "12", "10"},
            {"Earth", "Mars", "Jupiter", "Saturn"}
    };

    public int[] correctAnswers = {2, 1, 1, 2}; // Index of correct options
    private int currentQuestion = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questionTextView = findViewById(R.id.questionTextView);
        optionsRadioGroup = findViewById(R.id.optionsRadioGroup);
        nextButton = findViewById(R.id.nextButton);

        loadQuestion();

        nextButton.setOnClickListener(v -> {
            int selectedOption = optionsRadioGroup.indexOfChild(findViewById(optionsRadioGroup.getCheckedRadioButtonId()));

            if (selectedOption == correctAnswers[currentQuestion]) {
                score++;
            }

            currentQuestion++;

            if (currentQuestion < questions.length) {
                loadQuestion();
            } else {
                Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                intent.putExtra("SCORE", score);
                startActivity(intent);
            }
        });
    }

    private void loadQuestion() {
        questionTextView.setText(questions[currentQuestion]);
        ((RadioButton) optionsRadioGroup.getChildAt(0)).setText(options[currentQuestion][0]);
        ((RadioButton) optionsRadioGroup.getChildAt(1)).setText(options[currentQuestion][1]);
        ((RadioButton) optionsRadioGroup.getChildAt(2)).setText(options[currentQuestion][2]);
        ((RadioButton) optionsRadioGroup.getChildAt(3)).setText(options[currentQuestion][3]);
        optionsRadioGroup.clearCheck();
    }
}
