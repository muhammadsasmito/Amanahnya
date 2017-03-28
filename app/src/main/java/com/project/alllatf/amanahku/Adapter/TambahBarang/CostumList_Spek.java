package com.project.alllatf.amanahku.Adapter.TambahBarang;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.project.alllatf.amanahku.Data.PesanBrg.DataSpesifikasi;
import com.project.alllatf.amanahku.R;

import java.util.ArrayList;

/**
 * Created by User on 28/03/2017.
 */

public class CostumList_Spek extends ArrayAdapter<DataSpesifikasi> {

    Context context;
    ArrayList<DataSpesifikasi> values;

    public CostumList_Spek(Context context,ArrayList<DataSpesifikasi> values){
        super(context, R.layout.daftar_spesifikasi,values);
        this.context = context;
        this.values = values;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.daftar_spesifikasi,parent,false);
        TextView tvSpekJenis = (TextView) view.findViewById(R.id.tvSpekJenis);
        TextView tvSpekDetail = (TextView) view.findViewById(R.id.tvSpekDetail);

        tvSpekJenis.setText(values.get(position).spekJenis);
        tvSpekDetail.setText(values.get(position).spekDetail);

        return view;
    }
}
