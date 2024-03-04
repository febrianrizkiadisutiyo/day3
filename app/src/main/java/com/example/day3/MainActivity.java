package com.example.day3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btnbawaData, btnBagikan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btnbawaData = findViewById(R.id.btnbawaData);
        btnBagikan = findViewById(R.id.btnbagikan);
        Klik();
    }
    void Klik () {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Halaman2 = new Intent(MainActivity.this, Halaman2Activity.class);
                startActivity(Halaman2);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Halaman3 = new Intent(MainActivity.this, Halaman3Activity.class);
                startActivity(Halaman3);
            }
        });
        btnbawaData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String coba = "Halo";
                Intent intentPutData = new Intent(MainActivity.this, Halaman3Activity.class);
                intentPutData.putExtra(Halaman3Activity.EXTRA_NAMA, "Febrian");
                intentPutData.putExtra(Halaman3Activity.EXTRA_NIM, 12081);
                startActivity(intentPutData);
            }
        });
//        intent implisit
        btnBagikan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentShare = new Intent();
                intentShare.setAction(Intent.ACTION_SEND);
                intentShare.putExtra(Intent.EXTRA_TEXT, "cobba lagi");
                intentShare.setType("text/plain");

                if (intentShare.resolveActivity(getPackageManager()) != null){
                    startActivity(intentShare);
//                    startActivity(Intent.createChooser(intentShare,"Share to:"));
                }
            }
        });

    }
}