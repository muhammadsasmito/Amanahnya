package com.project.alllatf.amanahku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class StatusPesanan extends AppCompatActivity {

    TextView tvStatus;
    TextView tvTglStatus;
    TextView tvPersonStatus;
    TextView tvLokasiStatus;

    Spinner spinnerAngsuran;

    String cekStats;

    LinearLayout llCb1;
    LinearLayout llCb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_pesanan);

        tvStatus = (TextView) findViewById(R.id.tvStatus);
        tvTglStatus = (TextView) findViewById(R.id.tvTglStatus);
        tvPersonStatus = (TextView) findViewById(R.id.tvPersonStatus);
        tvLokasiStatus = (TextView) findViewById(R.id.tvLokasiStatus);
        spinnerAngsuran = (Spinner) findViewById(R.id.spStatus_angsuranInterval);
        llCb1 = (LinearLayout) findViewById(R.id.llCb16);
        llCb2 = (LinearLayout) findViewById(R.id.llCb712);

        Button btnTemui = (Button) findViewById(R.id.btnTemui);
        TextView tvAngsuran = (TextView) findViewById(R.id.tvAngsuran);
        LinearLayout llangsuran = (LinearLayout) findViewById(R.id.llAngsuran);

        Intent i = getIntent();
        cekStats =  i.getStringExtra("STATSNAME").toString();

        if (cekStats.equals("BELUM")){
            tvStatus.setText("Belum dikonfirmasi");
            tvStatus.setBackgroundResource(R.color.colorRed);
            tvLokasiStatus.setText("-");
            tvTglStatus.setText("-");
            tvPersonStatus.setText("-");
            btnTemui.setVisibility(View.GONE);
            tvAngsuran.setVisibility(View.GONE);
            llangsuran.setVisibility(View.GONE);

        }else if(cekStats.equals("SUDAH")){
            tvStatus.setText("Sudah dikonfirmasi");
            tvStatus.setBackgroundResource(R.color.colorTealDark);
            tvLokasiStatus.setText("Indomaret Point Colombo");
            tvTglStatus.setText("08:00 WIB, 4 Maret 2017");
            tvPersonStatus.setText("Bp Ragil (083867816675)");
            tvAngsuran.setVisibility(View.GONE);
            llangsuran.setVisibility(View.GONE);
        }else if(cekStats.equals("BAYAR")){
            tvStatus.setBackgroundResource(R.color.colorGreen);
            tvStatus.setText("Pembayaran");
            tvLokasiStatus.setText("Indomaret Point Colombo");
            tvTglStatus.setText("08:00 WIB, 4 Maret 2017");
            tvPersonStatus.setText("Bp Ragil (083867816675)");
            btnTemui.setVisibility(View.GONE);

        }else if(cekStats.equals("LUNAS")){
            tvStatus.setBackgroundResource(R.color.colorLBlue);
            tvStatus.setText("Lunas");
            tvLokasiStatus.setText("Indomaret Point Colombo");
            tvTglStatus.setText("08:00 WIB, 4 Maret 2017");
            tvPersonStatus.setText("Bp Ragil (083867816675)");
            btnTemui.setVisibility(View.GONE);
        }

//        if (spinnerAngsuran.getSelectedItem().toString() == 4+""){
//            for(int ia = 0; ia < 4; ia++) {
//                CheckBox cb = new CheckBox(getApplicationContext());
//                llCb.addView(cb);
//                CheckBox cb2 = new CheckBox(getApplicationContext());
//                llCb.addView(cb2);
//            }
//        }else if (spinnerAngsuran.getSelectedItem().toString() == 6+""){
//            for(int ia = 0; ia < 6; ia++) {
//                CheckBox cb = new CheckBox(getApplicationContext());
//                llCb.addView(cb);
//            }
//        }else if (spinnerAngsuran.getSelectedItem().toString() == 8+""){
//            for(int ia = 0; ia < 8; ia++) {
//                CheckBox cb = new CheckBox(getApplicationContext());
//                llCb.addView(cb);
//            }
//        }else if (spinnerAngsuran.getSelectedItem().toString() == 10+""){
//            for(int ia = 0; ia < 10; ia++) {
//                CheckBox cb = new CheckBox(getApplicationContext());
//                llCb.addView(cb);
//            }
//        }else if (spinnerAngsuran.getSelectedItem().toString() == 12+""){
//            for(int ia = 0; ia < 12; ia++) {
//                CheckBox cb = new CheckBox(getApplicationContext());
//                llCb.addView(cb);
//            }
//        }





    }
}
