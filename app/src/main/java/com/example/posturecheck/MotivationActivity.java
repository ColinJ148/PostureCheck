package com.example.posturecheck;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MotivationActivity extends AppCompatActivity {
    private String[] quotes = {"\"If you want to achieve greatness stop asking for permission.\" " +
            "--Anonymous", "\"Trust because you are willing to accept the risk, not because it's " +
            "safe or certain.\" --Anonymous",
            "\"Success is walking from failure to failure with no loss of enthusiasm.\" --Winston" +
                    " Churchill", "\"I have not failed. I've just found 10,000 ways that won't " +
            "work.\" --Thomas A. Edison", "\"The distance between insanity and genius is measured" +
            " " +
            "only by success.\" --Bruce Feirstein"};
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motivation);
        final TextView quotesView = findViewById(R.id.motivationQuotes);
        Button newQuotesBtn = findViewById(R.id.newQuoteBtn);

        newQuotesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numOfQuotes = quotes.length;
                random = new Random();
                String output = quotes[random.nextInt(numOfQuotes)];
                quotesView.setText(output);
            }
        });
    }
}
