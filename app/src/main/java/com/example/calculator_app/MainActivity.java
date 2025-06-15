package com.example.calculator_app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edta, edtb, edtkq;
    Button btncong, btntru, btnnhan, btnchia, btnclear;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
       // ánh xạ
        edta = findViewById(R.id.edta);
        edtb = findViewById(R.id.edtb);
        edtkq = findViewById(R.id.edtkq);
        btncong = findViewById(R.id.btncong);
        btntru = findViewById(R.id.btntru);
        btnnhan = findViewById(R.id.btnnhan);
        btnchia = findViewById(R.id.btnchia);
        btnclear = findViewById(R.id.btnclear);
        // xử lý click
        btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(edta.getText().toString());
                int b = Integer.parseInt(edtb.getText().toString());
                int c = a + b;
                edtkq.setText(c+"");
            }
        });
        btntru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(edta.getText().toString());
                int b = Integer.parseInt(edtb.getText().toString());
                int c = a - b;
                edtkq.setText(c+"");
            }
        });
        btnnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(edta.getText().toString());
                int b = Integer.parseInt(edtb.getText().toString());
                int c = a * b;
                edtkq.setText(c+"");
            }
        });
        btnchia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(edta.getText().toString());
                int b = Integer.parseInt(edtb.getText().toString());
                int c = a / b;
                edtkq.setText(c+"");
            }
        });
        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edta.setText("");
                edtb.setText("");

            }
        });

    }
}