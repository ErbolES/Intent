package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private String receivedName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textViewName = findViewById(R.id.textViewName);
        Button buttonUpperCase = findViewById(R.id.buttonUpperCase);
        Button buttonOriginal = findViewById(R.id.buttonOriginal);

        receivedName = getIntent().getStringExtra("name");
        textViewName.setText(receivedName);

        buttonUpperCase.setOnClickListener(v -> returnResult(receivedName.toUpperCase()));
        buttonOriginal.setOnClickListener(v -> returnResult(receivedName));
    }

    private void returnResult(String result) {
        Intent intent = new Intent();
        intent.putExtra("result", result);
        setResult(RESULT_OK, intent);
        finish();
    }
}

