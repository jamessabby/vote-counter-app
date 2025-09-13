package com.example.sabio_activity_2_counter_app;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import android.graphics.Color;
import androidx.core.content.ContextCompat;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CounterPage extends AppCompatActivity {

    String c1, c2, c3;

    Button candidate1Name, candidate2Name, candidate3Name, addButton, subtractButton;

    TextView counter;

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

        candidate1Name.setOnClickListener(v -> {
            counter.setTextColor(Color.parseColor("#FDDE55"));
        });

        candidate2Name.setOnClickListener(v -> {
            counter.setTextColor(Color.parseColor("#00FF9C"));
        });

        candidate3Name.setOnClickListener(v -> {
            counter.setTextColor(Color.parseColor("#FFA500"));;
        });


        addButton.setOnClickListener(v -> {
            int count = Integer.parseInt(counter.getText().toString());
            count++;
            counter.setText(String.valueOf(count));
        });

        subtractButton.setOnClickListener(v -> {
            int count = Integer.parseInt(counter.getText().toString());
            if (count > 0) {
                count--;
                counter.setText(String.valueOf(count));
            }
        });

    }

}