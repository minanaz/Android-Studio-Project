// Student: Amina Nazarova L1
// Student id: 54831
// SET 1

package com.example.mobilesystem;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    int randomNumber;
    int attempts = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Witaj input
        EditText editText = findViewById(R.id.editTextName);
        Button button = findViewById(R.id.buttonWitaj);
        TextView result = findViewById(R.id.textViewResult);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editText.getText().toString().trim();

                if (!input.isEmpty()) {
                    result.setText("Witaj " + input);
                } else {
                    result.setText("Przedstaw się.");
                }
            }
        });

        //Number guessing game
        randomNumber = (int)(Math.random() * 10) + 1;
        EditText editTextGuess = findViewById(R.id.editTextGuess);
        Button buttonGuess = findViewById(R.id.buttonGuess);
        TextView resultNumber = findViewById(R.id.textViewResultNumber);

        buttonGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String input = editTextGuess.getText().toString().trim();
                if (input.isEmpty()) {
                    resultNumber.setText("Please enter an integer number.");
                    return;
                }
                int guess;
                try {
                    guess = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    resultNumber.setText("Please enter an integer number.");
                    return;
                }
                if (guess < 1 || guess > 10) {
                    resultNumber.setText("Number must be in range 1..10.");
                    return;
                }
                attempts++;
                if (guess < randomNumber) {
                    resultNumber.setText("Value too small");
                }
                else if (guess > randomNumber) {
                    resultNumber.setText("Value too large");
                }
                else {
                    if (attempts == 2) {
                        resultNumber.setText("Correct, achieved on the 2nd attempt");
                        randomNumber = (int)(Math.random() * 10) + 1;
                        attempts = 0;
                    } else {
                        resultNumber.setText("Correct, but not on the 2nd attempt. Try again.");
                        randomNumber = (int)(Math.random() * 10) + 1;
                        attempts = 0;
                    }
                }
                editTextGuess.setText("");
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}