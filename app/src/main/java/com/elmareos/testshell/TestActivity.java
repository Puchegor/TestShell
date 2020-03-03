package com.elmareos.testshell;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {
    TextView tvTypeOfTest, tvTopic, tvQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        tvTypeOfTest = findViewById(R.id.tvTypeOfTest);
        tvTopic = findViewById(R.id.tvTopic);
        tvQuestion = findViewById(R.id.tvQuestion);

        tvTypeOfTest.setText(getIntent().getStringExtra("tvTypeOfTest"));//Вывести интент в отдельную переменную
    }
}
