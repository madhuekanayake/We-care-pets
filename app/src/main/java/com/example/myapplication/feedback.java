package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class feedback extends AppCompatActivity {

    private RatingBar ratingBar;
    private Button buttonSubmit;
    private TextView textViewSelectedEmoji;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        ratingBar = findViewById(R.id.ratingBar);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        textViewSelectedEmoji = findViewById(R.id.textViewSelectedEmoji);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitFeedback();
            }
        });
    }

    private void submitFeedback() {
        float rating = ratingBar.getRating();


        String emoji;
        if (rating < 1) {
            emoji = "😠";
        } else if (rating < 2) {
            emoji = "😞";
        } else if (rating < 3) {
            emoji = "😐";
        } else if (rating < 4) {
            emoji = "😊";
        } else {
            emoji = "😄";
        }


        textViewSelectedEmoji.setText("React Emoji: " + emoji);

        // You can handle the feedback submission here, for example, sending it to a server.
        // For now, let's just display a toast message with the selected rating.
        Toast.makeText(this, "Feedback submitted! Rating: " + rating, Toast.LENGTH_SHORT).show();
    }
}