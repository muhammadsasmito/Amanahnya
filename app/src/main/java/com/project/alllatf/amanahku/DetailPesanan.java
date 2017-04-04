package com.project.alllatf.amanahku;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.project.alllatf.amanahku.Adapter.PesanBrg.CostumList_PesanBrg;
import com.project.alllatf.amanahku.Data.PesanBrg.DataBarang;

import java.util.ArrayList;

public class DetailPesanan extends AppCompatActivity {

    ArrayList<DataBarang> barangList;
    CostumList_PesanBrg costumListAdapter;

    ListView lvBarang;

    String countBarang;
    TextView tvCountBrg;
    TextView tvSumBrg;
    Button btnStatus;

    /**
     * Jika list kosong maka tampilkan ini
     * default visibility : gone
     */
    TextView tvBrgKosong;

    Integer totalHarga = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pesanan);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_back_mini);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

        btnStatus = (Button) findViewById(R.id.btnStatus);
        //FloatingActionButton fabEdit = (FloatingActionButton) findViewById(R.id.fabEdit);
        btnStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent i = new Intent(DetailPesanan.this,StatusPesanan.class);
                i.putExtra("STATSNAME","BELUM");
                startActivity(i);
            }
        });

        lvBarang = (ListView) findViewById(R.id.lvBarang);
        tvCountBrg = (TextView) findViewById(R.id.tvCountBrg);
        tvSumBrg = (TextView) findViewById(R.id.tvSumBrg);
        tvBrgKosong = (TextView) findViewById(R.id.tvBrgKosong);





        /**
         * data dummy new arrraylist dibuat global dengan cara prosedural yang akan dipakai untuk
         * method2 setelahnya pada tambah pesanan
         */

        useBarangList();
        addDummyData();
        DummyData();


        /**
         * Menghitung jumlah barang yang dipesan
         */
        countBarang = barangList.size() + "";
        tvCountBrg.setText(countBarang);

        /**
         * set menghitung total biaya dari seluruh harga satuan object
         */
        tvSumBrg.setText(totalHarga+"");




        /**
         * Edit dan lihat detail Barang lama
         *
         */
        lvBarang.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                                    int position, long id) {
                DataBarang brg = (DataBarang) lvBarang.getItemAtPosition(position);
                Intent i = new Intent(DetailPesanan.this,TambahBrg.class);
                i.putExtra("nav","edit");
                i.putExtra("EDJUDUL","Detail \nBarang");
                i.putExtra("EDJENIS",brg.BarangFormJudul);
                i.putExtra("EDHARGA",brg.BarangFormHarga+"");
                i.putExtra("EDJUMLAH",brg.BarangFormJumlah+"");
                startActivity(i);
            }
        });
    }

    private void DummyData() {

        DataBarang barang = new DataBarang();
        barang.BarangFormJudul = "Mesin Cuci";
        barang.BarangFormJumlah = 1;
        barang.BarangFormGambar = null;
        //barang.BarangFormHarga = 0;
        barang.BarangFormHarga = 1000000;
        totalHarga = totalHarga + barang.BarangFormHarga;
        barangList.add(barang);

        DataBarang baranga = new DataBarang();
        baranga.BarangFormJudul = "Sepeda";
        baranga.BarangFormJumlah = 2;
        baranga.BarangFormGambar = null;
        //barang.BarangFormHarga = 0;
        baranga.BarangFormHarga = 500000;
        totalHarga = totalHarga + baranga.BarangFormHarga;
        barangList.add(baranga);

        costumListAdapter = new CostumList_PesanBrg(this,barangList);
        lvBarang.setAdapter(costumListAdapter);
    }

    public void useBarangList(){
        barangList = new ArrayList<>();
    }

    public void addDummyData() {
        /**
         * dummy arraylist
         */
        useBarangList();
        Intent i = getIntent();
        DataBarang barang = new DataBarang();
        barang.BarangFormJudul = i.getStringExtra("JENIS");
        barang.BarangFormJumlah = i.getIntExtra("JUMLAH",0);
        barang.BarangFormGambar = null;
        //barang.BarangFormHarga = 0;
        barang.BarangFormHarga = i.getIntExtra("HARGA",0);
        totalHarga = totalHarga + barang.BarangFormHarga;
        barangList.add(barang);

        costumListAdapter = new CostumList_PesanBrg(this,barangList);
        lvBarang.setAdapter(costumListAdapter);

    }

}
