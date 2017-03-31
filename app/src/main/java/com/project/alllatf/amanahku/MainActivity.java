package com.project.alllatf.amanahku;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.project.alllatf.amanahku.Fragment.GuestModal.GuestModal_dialogFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //load dialog fragment
        DialogFragment dialogFragment = new GuestModal_dialogFragment();
        dialogFragment.show(getFragmentManager(), "Dialog Guest");
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //menyembunyikan actionbar
        //getActionBar().hide();
        getSupportActionBar().hide();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Intent i = new Intent(this,TambahBrg.class);
//        startActivity(i);

        /**
         * Yang tadinya menu tab slide untuk menambahkan pesanan menggunakan aktivity baru
         * pindah ke aktivity pesanbarang
         */
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabPesanBrg);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,PesanBrg.class);
                startActivity(i);
            }
        });
    }
}
