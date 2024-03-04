package com.example.day3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Halaman3Activity extends AppCompatActivity {
    TextView tvnama, tvnim;
    public static String EXTRA_NAMA = "extra_nama";
    public static String EXTRA_NIM = "extra_nim";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman3);
        tvnama = findViewById(R.id.tvnama);
        tvnim = findViewById(R.id.tvnim);
        setText();
    }

    void setText(){
        tvnama.setText(getIntent().getStringExtra(EXTRA_NAMA));
        tvnim.setText(String.valueOf(getIntent().getIntExtra(EXTRA_NIM, 0)));
    }
}