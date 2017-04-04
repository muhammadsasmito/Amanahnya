package com.project.alllatf.amanahku.Fragment.GuestModal;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.project.alllatf.amanahku.Adapter.GuestModal.CustomExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.project.alllatf.amanahku.MenuUtama;
import com.project.alllatf.amanahku.R;
import com.project.alllatf.amanahku.Register;

/**
 * Created by fachrul on 3/21/17.
 */

public class GuestModal_dialogFragment extends android.app.DialogFragment {
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.modal_dialog_guest, null);
        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels;

//        Button btRegister = (Button) view.findViewById(R.id.btRegister);
        Button btTutup = (Button) view.findViewById(R.id.btTutup);

        expandableListView = (ExpandableListView) view.findViewById(R.id.lvExp);
        expandableListDetail = GuestModal_dataList.getData();
        expandableListTitle = new ArrayList<>(expandableListDetail.keySet());
        expandableListAdapter = new CustomExpandableListAdapter(this.getActivity(), expandableListTitle, expandableListDetail);

        //mencoba mindah indicator disebelah kanan
        if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {
            expandableListView.setIndicatorBounds(width - GetDipsFromPixel(35), width - GetDipsFromPixel(10));

        } else {
            expandableListView.setIndicatorBoundsRelative(width - GetDipsFromPixel(35), width - GetDipsFromPixel(10));

        }
        expandableListView.setAdapter(expandableListAdapter);

        //listener waktu expand dan collapse
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getActivity(), expandableListTitle.get(groupPosition)
                        + "Group Expanded.", Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getActivity(), expandableListTitle.get(groupPosition)
                        + "List Collapse", Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(getActivity(), expandableListTitle.get(groupPosition)
                        + " -> " + expandableListDetail.get(expandableListTitle.get(groupPosition)).get(childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });

        //listener klik tombol register
//        btRegister.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), Register.class);
//                startActivity(intent);
//            }
//        });

        btTutup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MenuUtama.class);
                startActivity(intent);
            }
        });


        builder.setView(view);
        return builder.create();
        // return super.onCreateDialog(savedInstanceState);
    }

    //function konversi pixel ke dp (dips)
    public int GetDipsFromPixel(float pixels)
    {
        // Get the screen's density scale
        final float scale = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (pixels * scale + 0.5f);
    }
}
