package com.project.alllatf.amanahku;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.project.alllatf.amanahku.Adapter.TambahBarang.CostumList_Spek;
import com.project.alllatf.amanahku.Data.PesanBrg.DataSpesifikasi;
import com.project.alllatf.amanahku.Fragment.TambahSpekDialog.TambahSpek_dialogFragment;

import java.util.ArrayList;

public class TambahBrg extends AppCompatActivity {

    ArrayList<DataSpesifikasi> spekList;
    CostumList_Spek costumList_spek;

    ListView lvSpek;

    ImageButton ibtnTambahBrg;
    EditText etJenisBrg;
    EditText etHargaBrg;
    EditText etJumlahBrg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_brg);

        lvSpek = (ListView) findViewById(R.id.lvSpek);
        ibtnTambahBrg = (ImageButton) findViewById(R.id.ibtnTambahBrg);
        etJenisBrg = (EditText) findViewById(R.id.etJenisBarang);
        etHargaBrg = (EditText) findViewById(R.id.etHargaBarang);
        etJumlahBrg = (EditText) findViewById(R.id.etJumlahBarang);

        spekList = new ArrayList<>();

        DataSpesifikasi spesifikasi = new DataSpesifikasi();
        spesifikasi.spekJenis = "Merk";
        spesifikasi.spekDetail = "Thinkpad Lenovo";
        spekList.add(spesifikasi);

        DataSpesifikasi spesifikasi1 = new DataSpesifikasi();
        spesifikasi1.spekJenis = "RAM";
        spesifikasi1.spekDetail = "2GB";
        spekList.add(spesifikasi1);

        DataSpesifikasi spesifikasi2 = new DataSpesifikasi();
        spesifikasi2.spekJenis = "Processor";
        spesifikasi2.spekDetail = "i5 Intel";
        spekList.add(spesifikasi2);

        DataSpesifikasi spesifikasi3 = new DataSpesifikasi();
        spesifikasi3.spekJenis = "HDD";
        spesifikasi3.spekDetail = "1TB";
        spekList.add(spesifikasi3);

        costumList_spek = new CostumList_Spek(this,spekList);
        lvSpek.setAdapter(costumList_spek);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabAddBrg);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //load dialog fragment
            DialogFragment dialogFragment = new TambahSpek_dialogFragment();
            dialogFragment.show(getFragmentManager(), "Tambah Spesifikasi Barang");
            }
        });

        ibtnTambahBrg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TambahBrg.this,PesanBrg.class);
                i.putExtra("JENIS",etJenisBrg.getText().toString());
                i.putExtra("HARGA",etHargaBrg.getText().toString());
                i.putExtra("JUMLAH",etJumlahBrg.getText().toString());
                startActivity(i);
            }
        });
    }
}
