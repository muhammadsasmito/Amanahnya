package com.project.alllatf.amanahku.Adapter.PesanBrg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.alllatf.amanahku.Data.PesanBrg.DataBarang;
import com.project.alllatf.amanahku.R;

import java.util.ArrayList;


/**
 * Created by User on 25/03/2017.
 */

public class CostumList_PesanBrg extends ArrayAdapter<DataBarang>{

    Context context;
    ArrayList<DataBarang> values;

    public CostumList_PesanBrg(Context context,ArrayList<DataBarang> values) {
        super(context, R.layout.daftar_pesan_brg, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view =  inflater.inflate(R.layout.daftar_pesan_brg,parent,false);
        TextView tvPesanBrgJudul = (TextView) view.findViewById(R.id.tvPesanBrgJudul);
        TextView tvPesanBrgJumlah = (TextView) view.findViewById(R.id.tvPesanBrgJumlah);
        TextView tvPesanBrgHarga = (TextView) view.findViewById(R.id.tvPesanBrgHarga);
        ImageView ivPesanBrgGambar = (ImageView) view.findViewById(R.id.ivPesanBrgGambar);

        tvPesanBrgJudul.setText(values.get(position).BarangFormJudul);
        tvPesanBrgJumlah.setText(values.get(position).BarangFormJumlah+"");
        tvPesanBrgHarga.setText(values.get(position).BarangFormHarga+"");

        return view;
    }
}
