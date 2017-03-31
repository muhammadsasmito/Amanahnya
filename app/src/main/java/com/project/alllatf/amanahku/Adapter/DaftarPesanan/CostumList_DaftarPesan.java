package com.project.alllatf.amanahku.Adapter.DaftarPesanan;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.project.alllatf.amanahku.Data.PesanBrg.DataBarang;
import com.project.alllatf.amanahku.Data.PesanBrg.DataPesanan;
import com.project.alllatf.amanahku.R;

import java.util.ArrayList;

/**
 * Created by User on 31/03/2017.
 */

class CostumList_DaftarPesan extends ArrayAdapter<DataPesanan>{

    Context context;
    ArrayList<DataBarang> values;

    public CostumList_DaftarPesan(Context context,
                                  ArrayList<DataPesanan>values) {
        super(context, R.layout.daftar_pesanan,values);
    }
}
