package com.example.tugasquiz1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button button_ok;
    private TextView TV_nama, TV_barang, TV_code, TV_harga, TV_jumlah, TV_bayar, TV_total, TV_bonus, TV_kembalian, TV_keterangan;
    private EditText ET_nama, ET_barang, ET_code, ET_harga, ET_jumlah, ET_bayar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Tugas Quiz1 Januarico Rahsukma");

        button_ok = (Button) findViewById(R.id.buttonok);

        TV_nama = (TextView) findViewById(R.id.TVnama);
        TV_barang = (TextView) findViewById(R.id.TVbarang);
        TV_code = (TextView) findViewById(R.id.TVcode);
        TV_harga = (TextView) findViewById(R.id.TVharga);
        TV_jumlah = (TextView) findViewById(R.id.TVjumlah);
        TV_bayar = (TextView) findViewById(R.id.TVbayar);
        TV_total = (TextView) findViewById(R.id.TVtotal);
        TV_bonus = (TextView) findViewById(R.id.TVbonus);
        TV_kembalian = (TextView) findViewById(R.id.TVkembalian);
        TV_keterangan = (TextView) findViewById(R.id.TVketerangan);

        ET_nama = (EditText) findViewById(R.id.ETnama);
        ET_barang = (EditText) findViewById(R.id.ETbarang);
        ET_code = (EditText) findViewById(R.id.ETcode);
        ET_harga = (EditText) findViewById(R.id.ETharga);
        ET_jumlah = (EditText) findViewById(R.id.ETjumlah);
        ET_bayar = (EditText) findViewById(R.id.ETbayar);

        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentOk = new Intent(MainActivity.this, MainActivity2.class);

                String nama = ET_nama.getText().toString();
                String barang = ET_barang.getText().toString();
                String code = ET_code.getText().toString();
                String harga = ET_harga.getText().toString();
                String jumlah = ET_jumlah.getText().toString();
                String bayar = ET_bayar.getText().toString();
                String TVtotal = TV_total.getText().toString();
                String TVbonus = TV_bonus.getText().toString();
                String TVkembalian = TV_kembalian.getText().toString();
                String TVketerangan = TV_keterangan.getText().toString();

                double uh = Double.parseDouble(harga);
                double uj = Double.parseDouble(jumlah);
                double ub = Double.parseDouble(bayar);
                double total = (uj * uh);
                double bonus = (total - 100000);

                TV_total.setText("Total Belanja : " + total);
                if (total >= 10000000) {
                    TV_bonus.setText("Anda Mendapatkan Potongan Harga 100.000 menjadi : " + bonus);
                } else {
                    TV_bonus.setText("Tidak Mendapat potongan harga");
                }

                double kembalian = (ub - total);
                if (ub < total) {
                    TV_keterangan.setText("Keterangan : Uang Anda kurang Rp. " + (-kembalian));
                    TV_kembalian.setText("Uang Kembalian : Rp. 0");
                } else {
                    TV_keterangan.setText("Keterangan : Tunggu Kembalian");
                    TV_kembalian.setText("Uang Kembalian : " + kembalian);
                }

                intentOk.putExtra(MainActivity2.EXTRA_NAMA, "Nama : " + nama);
                intentOk.putExtra(MainActivity2.EXTRA_BARANG, "Barang : " + barang);
                intentOk.putExtra(MainActivity2.EXTRA_CODE, "Code : " + code);
                intentOk.putExtra(MainActivity2.EXTRA_HARGA, "Harga : " + harga);
                intentOk.putExtra(MainActivity2.EXTRA_JUMLAH, "Jumlah : " + jumlah);
                intentOk.putExtra(MainActivity2.EXTRA_BAYAR, "Bayar : " + bayar);
                intentOk.putExtra(MainActivity2.EXTRA_TOTAL, "Total Belanja adalah : " + total);
                intentOk.putExtra(MainActivity2.EXTRA_BONUS, "Anda Mendapatkan Bonus menjadi : " + bonus);
                intentOk.putExtra(MainActivity2.EXTRA_KEMBALIAN, "Kembalian Anda : " + (kembalian));
                intentOk.putExtra(MainActivity2.EXTRA_KETERANGAN, "Keterangan : Tunggu Kembalian");
                startActivity(intentOk);

            }
        });
    }
}