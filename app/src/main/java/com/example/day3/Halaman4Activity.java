package com.example.day3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Halaman4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman4);

        EditText etKodeBarang = findViewById(R.id.etkodeBarang);
        EditText etJumlah = findViewById(R.id.etJumlah);
        Button btnHitung = findViewById(R.id.btnHitung);
        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHitung = new Intent(Halaman4Activity.this, ResultActivity.class);
                String KodeBarang = etKodeBarang.getText().toString().trim();
                Integer Jumlah = Integer.parseInt(etJumlah.getText().toString());
                String diskon = "10";
                switch (KodeBarang) {
                    case "lnv": {
                        String lenovo = "Lenovo";
                        int hargalnv = 5000000;
                        intentHitung.putExtra("NamaBarang",lenovo);
                        int totalHarga = Jumlah*hargalnv;
                        if (totalHarga >= 10000000) {
                            int Diskon = (totalHarga * Integer.parseInt(diskon))/100;
                            intentHitung.putExtra("Diskon",Diskon);
                        }
                        intentHitung.putExtra("TotalHarga",totalHarga);
                        break;
                    }
                    default: {
                        intentHitung.putExtra("NamaBarang", "Barang Tidak Tersedia");
                    }
                }

                startActivity(intentHitung);
            }
        });
        Button btnshare = findViewById(R.id.btnshare);
        btnshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentShare = new Intent();
                intentShare.setAction(Intent.ACTION_SEND);
                String KodeBarang = etKodeBarang.getText().toString().trim();
                Integer Jumlah = Integer.parseInt(etJumlah.getText().toString());
                String diskon = "10";
                switch (KodeBarang) {
                    case "lnv": {
                        String lenovo = "Lenovo";
                        int hargalnv = 5000000;
//                        intentHitung.putExtra("NamaBarang",lenovo);
                        int totalHarga = Jumlah*hargalnv;
                        if (totalHarga >= 10000000) {
                            int Diskon = (totalHarga * Integer.parseInt(diskon))/100;
                            String TextDiskon = String.valueOf(Diskon);;
//                            intentHitung.putExtra("Diskon",Diskon);
                            String hasil = "Nama barang :" + lenovo + "\n" + "Total Harga :"+totalHarga + "\n" + "Diskon :" + TextDiskon;
                            intentShare.putExtra(Intent.EXTRA_TEXT, hasil);
                            intentShare.setType("text/plain");
                        }
                        String hasil = "Nama barang :" + lenovo + "\n" + "Total Harga :"+totalHarga + "\n" + "Diskon : Anda Belum memiliki Diskon";
                        intentShare.putExtra(Intent.EXTRA_TEXT, hasil);
                        intentShare.setType("text/plain");
                        break;
                    }
                    default: {
                        String hasil = "Barang tidak ada";
                        intentShare.putExtra(Intent.EXTRA_TEXT, hasil);
                        intentShare.setType("text/plain");
                    }
                }


                if (intentShare.resolveActivity(getPackageManager()) != null){
                    startActivity(intentShare);
//                    startActivity(Intent.createChooser(intentShare,"Share to:"));
                }
            }
        });
    }
}