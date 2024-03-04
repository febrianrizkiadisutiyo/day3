package com.example.day3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;

public class ResultActivity extends AppCompatActivity {
    EditText etNamaBarang, etTotalharga, etDiskon;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        etNamaBarang = findViewById(R.id.etNamaBarang);
        etTotalharga = findViewById(R.id.etTotalHarga);
        etDiskon = findViewById(R.id.etDiskon);
        etNamaBarang.setText(getIntent().getStringExtra("NamaBarang"));
        etTotalharga.setText(String.valueOf(getIntent().getIntExtra("TotalHarga", 0)));
//        etNamaBarang.setText(getIntent().getStringExtra("Diskon"));
        etDiskon.setText(String.valueOf(getIntent().getIntExtra("Diskon",0)));
    }
}