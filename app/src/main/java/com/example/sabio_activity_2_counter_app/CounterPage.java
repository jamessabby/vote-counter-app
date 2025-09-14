package com.example.sabio_activity_2_counter_app;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import android.graphics.Color;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CounterPage extends AppCompatActivity {

    String c1, c2, c3;

    Button candidate1Name, candidate2Name, candidate3Name, addButton, subtractButton;

    TextView counter;
    TextView candidate1Count;
    TextView candidate2Count;
    TextView candidate3Count;

    int candidate1CountValue = 0;
    int candidate2CountValue = 0;
    int candidate3CountValue = 0;

    boolean candidate1Selected, candidate2Selected, candidate3Selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_counter_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addButton = findViewById(R.id.addButton);
        subtractButton = findViewById(R.id.subtractButton);
        counter = findViewById(R.id.counter);

        candidate1Count = findViewById(R.id.candidate1Count);
        candidate2Count = findViewById(R.id.candidate2Count);
        candidate3Count = findViewById(R.id.candidate3Count);

        Intent intent = getIntent();

        c1 = intent.getStringExtra("candidate1");
        c2 = intent.getStringExtra("candidate2");
        c3 = intent.getStringExtra("candidate3");


        candidate1Name = findViewById(R.id.candidate1Name);
        candidate2Name = findViewById(R.id.candidate2Name);
        candidate3Name = findViewById(R.id.candidate3Name);

        if (c1 == null || c1.isEmpty()) c1 = "Candidate 1";
        if (c2 == null || c2.isEmpty()) c2 = "Candidate 2";
        if (c3 == null || c3.isEmpty()) c3 = "Candidate 3";


        candidate1Name.setText(c1);
        candidate2Name.setText(c2);
        candidate3Name.setText(c3);

        updateAllDisplays();

        candidate1Name.setOnClickListener(v -> {
            candidate1Selected = true;
            candidate2Selected = false;
            candidate3Selected = false;
            selectedCandidate();
        });

        candidate2Name.setOnClickListener(v -> {
            candidate1Selected = false;
            candidate2Selected = true;
            candidate3Selected = false;
            selectedCandidate();
        });

        candidate3Name.setOnClickListener(v -> {
            candidate1Selected = false;
            candidate2Selected = false;
            candidate3Selected = true;
            selectedCandidate();
        });

        addButton.setOnClickListener(v -> {
            if (candidate1Selected) {
                candidate1CountValue++;
                counter.setText(String.valueOf(candidate1CountValue));
                candidate1Count.setText(String.valueOf(candidate1CountValue));
            } else if (candidate2Selected) {
                candidate2CountValue++;
                counter.setText(String.valueOf(candidate2CountValue));
                candidate2Count.setText(String.valueOf(candidate2CountValue));
            } else if (candidate3Selected) {
                candidate3CountValue++;
                counter.setText(String.valueOf(candidate3CountValue));
                candidate3Count.setText(String.valueOf(candidate3CountValue));
            }

        });

        subtractButton.setOnClickListener(v -> {
            if (candidate1Selected) {
                candidate1CountValue--;
                counter.setText(String.valueOf(candidate1CountValue));
                candidate1Count.setText(String.valueOf(candidate1CountValue));
            } else if (candidate2Selected) {
                candidate2CountValue--;
                counter.setText(String.valueOf(candidate2CountValue));
                candidate2Count.setText(String.valueOf(candidate2CountValue));
            } else if (candidate3Selected) {
                candidate3CountValue--;
                counter.setText(String.valueOf(candidate3CountValue));
                candidate3Count.setText(String.valueOf(candidate3CountValue));
            }
        });
    }

    private void updateAllDisplays() {
        candidate1Count.setText(String.valueOf(candidate1CountValue));
        candidate2Count.setText(String.valueOf(candidate2CountValue));
        candidate3Count.setText(String.valueOf(candidate3CountValue));
    }

    private void selectedCandidate() {
        if (candidate1Selected) {
            counter.setTextColor(Color.parseColor("#FDDE55"));
            counter.setText(String.valueOf(candidate1CountValue));
            candidate1Count.setText(String.valueOf(candidate1CountValue));

        } else if (candidate2Selected) {
            counter.setTextColor(Color.parseColor("#00FF9C"));
            counter.setText(String.valueOf(candidate2CountValue));
            candidate2Count.setText(String.valueOf(candidate2CountValue));
        } else if (candidate3Selected) {
            counter.setTextColor(Color.parseColor("#FFA500"));
            counter.setText(String.valueOf(candidate3CountValue));
            candidate3Count.setText(String.valueOf(candidate3CountValue));
        }
    }

}