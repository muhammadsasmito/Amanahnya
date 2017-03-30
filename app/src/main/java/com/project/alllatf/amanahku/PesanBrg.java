package com.project.alllatf.amanahku;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import com.project.alllatf.amanahku.Adapter.PesanBrg.CostumList_PesanBrg;
import com.project.alllatf.amanahku.Data.PesanBrg.DataBarang;



public class PesanBrg extends AppCompatActivity {


    ArrayList<DataBarang> barangList;
    CostumList_PesanBrg costumListAdapter;

    ListView lvPesanan;

    String countBarang;
    TextView tvCountBrg;
    TextView tvSumBrg;

    /**
     * Jika list kosong maka tampilkan ini
     * default visibility : gone
     */
    TextView tvBrgKosong;

    Integer totalHarga = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan_brg);
        lvPesanan = (ListView) findViewById(R.id.lvPesanan);
        tvCountBrg = (TextView) findViewById(R.id.tvCountBrg);
        tvSumBrg = (TextView) findViewById(R.id.tvSumBrg);
        tvBrgKosong = (TextView) findViewById(R.id.tvBrgKosong);

        /**
         * data dummy new arrraylist dibuat global dengan cara prosedural yang akan dipakai untuk
         * method2 setelahnya pada tambah pesanan
         */
        addDummyData();


        /**
         * mengecek jika list kosong maka tampilkan saja text info kosong
         */
        if (barangList.size() == 0) {
            lvPesanan.setVisibility(View.GONE);
            tvBrgKosong.setVisibility(View.VISIBLE);
        }else{
            lvPesanan.setVisibility(View.VISIBLE);
            tvBrgKosong.setVisibility(View.GONE);
        }

        /**
         * Menghitung jumlah barang yang dipesan
         */
        countBarang = barangList.size() + "";
        tvCountBrg.setText(countBarang);

        /**
         * set menghitung total biaya dari seluruh harga satuan object
         */
        tvSumBrg.setText(totalHarga+"");


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /**
         * Menambah Barang Baru
         * pindah ke aktivity baru untuk menambah barang baru yang ingin dipesan
         * sementara akan berupa menambah datadummy dengan new object tapi menggunakan arraylist nya barangList
         */
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PesanBrg.this,TambahBrg.class);
                /** validasi saat set edittext untuk tambah atau edit */
                i.putExtra("nav","add");
                startActivity(i);
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });


        /**
         * Edit dan lihat detail Barang lama
         *
         */
        lvPesanan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                                    int position, long id) {
                DataBarang brg = (DataBarang) lvPesanan.getItemAtPosition(position);
                Intent i = new Intent(PesanBrg.this,TambahBrg.class);
                i.putExtra("nav","edit");
                i.putExtra("EDJENIS",brg.BarangFormJudul);
                i.putExtra("EDHARGA",brg.BarangFormHarga+"");
                i.putExtra("EDJUMLAH",brg.BarangFormJumlah+"");
                startActivity(i);
            }
        });
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
        lvPesanan.setAdapter(costumListAdapter);

    }

}
