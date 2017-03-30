package com.project.alllatf.amanahku;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
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
    EditText etJenisSpek;
    EditText etDetailSpek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_brg);

        lvSpek = (ListView) findViewById(R.id.lvSpek);
        ibtnTambahBrg = (ImageButton) findViewById(R.id.ibtnTambahBrg);
        etJenisBrg = (EditText) findViewById(R.id.etJenisBarang);
        etHargaBrg = (EditText) findViewById(R.id.etHargaBarang);
        etJumlahBrg = (EditText) findViewById(R.id.etJumlahBarang);

        etJenisSpek = (EditText) findViewById(R.id.etJenisSpek);
        etDetailSpek = (EditText) findViewById(R.id.etDetailSpek);

        /**
         * Validasi untuk kondisi edit atau add
         */
        Intent inten = getIntent();
        if (inten.getStringExtra("nav") == "add"){
            etJenisBrg.setText("");
            etHargaBrg.setText("");
            etJumlahBrg.setText("");
        }else if(inten.getStringExtra("nav") == "add"){
            etJenisBrg.setText(inten.getStringExtra("JENIS"));
            etHargaBrg.setText(inten.getStringExtra("HAGRA"));
            etJumlahBrg.setText(inten.getStringExtra("JUMLAH"));
        }


        /** dummy data spek */
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


        /**
         * intent data ke array list barang di aktivity Pesanbrg
         */
        ibtnTambahBrg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(TambahBrg.this,PesanBrg.class);
                i.putExtra("JENIS",etJenisBrg.getText().toString());
                i.putExtra("HARGA",Integer.parseInt(etHargaBrg.getText()+""));
                i.putExtra("JUMLAH",Integer.parseInt(etJumlahBrg.getText()+""));
                startActivity(i);
            }
        });

        /**
         * Menambah spesifikasi baru dengan modal
         */
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabAddBrg);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //load dialog fragment
            DialogFragment dialogFragment = new TambahSpek_dialogFragment();

            /** Creating a bundle object to store the position of the selected country */
            Bundle b = new Bundle();

            /** Storing the position in the bundle object */
            b.putString("modal", "Tambah");
            b.putString("jenis", "");
            b.putString("detail", "");

            /** Setting the bundle object as an argument to the DialogFragment object */
            dialogFragment.setArguments(b);

            /** Getting FragmentManager object */
            FragmentManager fragmentManager = getFragmentManager();

            /** Starting a FragmentTransaction */
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            dialogFragment.show(fragmentTransaction, "Tambah Spesifikasi Barang");
            }
        });

        /**
         * Edit dan lihat item detail spesifikasi dengan modal
         */
        lvSpek.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                DataSpesifikasi spek = (DataSpesifikasi) lvSpek.getItemAtPosition(position);
                DialogFragment dialogFragment = new TambahSpek_dialogFragment();

                /** Creating a bundle object to store the position of the selected country */
                Bundle b = new Bundle();

                /** Storing the position in the bundle object */
                b.putInt("position", position);
                b.putString("modal", "Edit");
                b.putString("jenis", spek.spekJenis+"");
                b.putString("detail", spek.spekDetail+"");

                /** Setting the bundle object as an argument to the DialogFragment object */
                dialogFragment.setArguments(b);

                /** Getting FragmentManager object */
                FragmentManager fragmentManager = getFragmentManager();

                /** Starting a FragmentTransaction */
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                /** Getting the previously created fragment object from the fragment manager */
                //TimeDialogFragment tPrev =  ( TimeDialogFragment ) fragmentManager.findFragmentByTag("time_dialog");

                /** If the previously created fragment object still exists, then that has to be removed */
                //if(tPrev!=null)
                //    fragmentTransaction.remove(tPrev);

                /** Opening the fragment object */
                dialogFragment.show(fragmentTransaction,"Edit Spesifikasi Barang");
                //Toast.makeText(TambahBrg.this,"edit item "+spek.spekJenis+" on modal",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
