package com.example.tugasquiz1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private Button button_hapus, button_berbagi;
    private TextView TV_nama, TV_barang, TV_code, TV_harga, TV_jumlah, TV_bayar, TV_total, TV_bonus, TV_kembalian, TV_keterangan;

    public static String EXTRA_NAMA = "extra_nama";
    public static String EXTRA_BARANG = "extra_barang";
    public static String EXTRA_CODE = "extra_code";
    public static String EXTRA_HARGA = "extra_harga";
    public static String EXTRA_JUMLAH = "extra_jumlah";
    public static String EXTRA_BAYAR = "extra_bayar";
    public static String EXTRA_TOTAL = "extra_total";
    public static String EXTRA_BONUS = "extra_bonus";
    public static String EXTRA_KEMBALIAN = "extra_kembalian";
    public static String EXTRA_KETERANGAN = "extra_keterangan";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        button_hapus = (Button) findViewById(R.id.buttonhapus);
        button_berbagi = (Button) findViewById(R.id.buttonberbagi);

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

        TV_nama.setText((getIntent().getStringExtra(EXTRA_NAMA)));
        TV_barang.setText((getIntent().getStringExtra(EXTRA_BARANG)));
        TV_code.setText((getIntent().getStringExtra(EXTRA_CODE)));
        TV_harga.setText((getIntent().getStringExtra(EXTRA_HARGA)));
        TV_jumlah.setText((getIntent().getStringExtra(EXTRA_JUMLAH)));
        TV_bayar.setText((getIntent().getStringExtra(EXTRA_BAYAR)));
        TV_total.setText((getIntent().getStringExtra(EXTRA_TOTAL)));
        TV_bonus.setText((getIntent().getStringExtra(EXTRA_BONUS)));
        TV_kembalian.setText((getIntent().getStringExtra(EXTRA_KEMBALIAN)));
        TV_keterangan.setText(getIntent().getStringExtra(EXTRA_KETERANGAN));

        button_hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentbuttonhapus = new Intent(MainActivity2.this, MainActivity.class);

                TV_total.setText("");
                TV_bonus.setText("");
                TV_kembalian.setText("");
                TV_keterangan.setText("");

                Toast.makeText(getApplicationContext(), "Data Sudah Dihapus", Toast.LENGTH_LONG).show();

                startActivity(intentbuttonhapus);
            }
        });

        button_berbagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, "Hallo");
                intent.setType(("text/plain"));

                if (intent.resolveActivity(getPackageManager()) !=null){
                    startActivity(intent);
                }
            }
        });
    }
}