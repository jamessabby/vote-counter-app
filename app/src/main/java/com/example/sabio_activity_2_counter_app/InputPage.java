    package com.example.sabio_activity_2_counter_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InputPage extends AppCompatActivity {

    Button enterBtn, voteBtn;

    EditText etName1, etName2, etName3;


    TextView candidate1Label, candidate2Label, candidate3Label;

    String candidate1, candidate2, candidate3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_input_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //  I get the EditTexts fields
        etName1 = findViewById(R.id.name1);
        etName2 = findViewById(R.id.name2);
        etName3 = findViewById(R.id.name3);

        // I initialized the TextViews so I can display the entered names after they clicked enter
        candidate1Label = findViewById(R.id.candidate1Label);
        candidate2Label = findViewById(R.id.candidate2Label);
        candidate3Label = findViewById(R.id.candidate3Label);

        // Initialize the buttons
        enterBtn = findViewById(R.id.enterButton);
        voteBtn = findViewById(R.id.voteButton);

        enterBtn.setOnClickListener(v -> {
            handleEnterAction();
        });

        etName1.setOnEditorActionListener((v, actionId, event) -> {
            boolean isEnter =
                    actionId == EditorInfo.IME_ACTION_DONE ||
                            actionId == EditorInfo.IME_ACTION_NEXT ||
                            (event != null &&
                                    event.getKeyCode() == KeyEvent.KEYCODE_ENTER &&
                                    event.getAction() == KeyEvent.ACTION_DOWN);

            if (isEnter) {
                handleEnterAction();
                return true;
            }
            return false;
        });

        etName2.setOnEditorActionListener((v, actionId, event) -> {
            boolean isEnter =
                    actionId == EditorInfo.IME_ACTION_DONE ||
                            actionId == EditorInfo.IME_ACTION_NEXT ||
                            (event != null &&
                                    event.getKeyCode() == KeyEvent.KEYCODE_ENTER &&
                                    event.getAction() == KeyEvent.ACTION_DOWN);

            if (isEnter) {
                handleEnterAction();
                return true;
            }
            return false;
        });

        etName3.setOnEditorActionListener((v, actionId, event) -> {
            boolean isEnter =
                    actionId == EditorInfo.IME_ACTION_DONE ||
                            actionId == EditorInfo.IME_ACTION_NEXT ||
                            (event != null &&
                                    event.getKeyCode() == KeyEvent.KEYCODE_ENTER &&
                                    event.getAction() == KeyEvent.ACTION_DOWN);

            if (isEnter) {
                handleEnterAction();
                return true;
            }
            return false;
        });

        voteBtn.setOnClickListener(buttonView -> {

            // when voteButton is clicked, it goes to the CounterPage

            Intent intent = new Intent(InputPage.this, CounterPage.class);

            intent.putExtra("candidate1", candidate1);
            intent.putExtra("candidate2", candidate2);
            intent.putExtra("candidate3", candidate3);

            startActivity(intent);
        });
    }

    private void handleEnterAction() {
        String t1 = etName1.getText().toString().trim();
        String t2 = etName2.getText().toString().trim();
        String t3 = etName3.getText().toString().trim();

        if (!t1.isEmpty()) {
            candidate1 = t1;
            candidate1Label.setText("Candidate 1: " + t1);
            etName1.setVisibility(View.GONE);
            etName1.setText("");
        }

        if (!t2.isEmpty()) {
            candidate2 = t2;
            candidate2Label.setText("Candidate 2: " + t2);
            etName2.setVisibility(View.GONE);
            etName2.setText("");
        }

        if (!t3.isEmpty()) {
            candidate3 = t3;
            candidate3Label.setText("Candidate 3: " + t3);
            etName3.setVisibility(View.GONE);
            etName3.setText("");
        }
    }
};

