package id.amanahku.amanahku;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import id.amanahku.amanahku.Data.PesanBrg.BarangForm_dataList;

public class TambahBarang extends AppCompatActivity{

    EditText etJenisBrg;
    EditText etHargaBrg;
    EditText etJumlahBrg;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_barang);
        etJenisBrg = (EditText) findViewById(R.id.etJenisBarang);
        etHargaBrg = (EditText) findViewById(R.id.etHargaBarang);
        etJumlahBrg = (EditText) findViewById(R.id.etJumlahBarang);

        FloatingActionButton fabTambah = (FloatingActionButton) findViewById(R.id.fabTambahBrg);
        fabTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TambahBarang.this,PesanBrg.class);
                i.putExtra("JENIS",etJenisBrg.getText().toString());
                i.putExtra("HARGA",etHargaBrg.getText().toString());
                i.putExtra("JUMLAH",etJumlahBrg.getText().toString());
                startActivity(i);

            }
        });



    }
}
