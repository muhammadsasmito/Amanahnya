package com.project.alllatf.amanahku.Fragment.TambahSpekDialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.project.alllatf.amanahku.Data.PesanBrg.DataSpesifikasi;
import com.project.alllatf.amanahku.R;
import com.project.alllatf.amanahku.TambahBrg;

import java.util.ArrayList;


/**
 * Created by User on 28/03/2017.
 */

public class TambahSpek_dialogFragment extends DialogFragment {

    Context context;
    ArrayList<DataSpesifikasi> values;


//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//
//        /** Inflating layout for the dialog */
//        View v = inflater.inflate(R.layout.dialog_tambah_spek, null);
//
//        /** Getting the arguments passed to this fragment. Here we expects the selected item's position as argument */
//        Bundle b = getArguments();
//
//        /** Setting the title for the dialog window */
//        getDialog().setTitle(b.getString("modal") +" Spesifikasi Barang");
//
//        /** If click the button ok and cancel */
//
//
//        /** Getting the reference to the TextView object of the layout */
//        EditText etJenis = (EditText) v.findViewById(R.id.etJenisSpek);
//        EditText etDetail = (EditText) v.findViewById(R.id.etDetailSpek);
//
//        /** Setting the current time to the TextView object of the layout */
//        /** tvJenis.setText(getCurTime(b.getInt("position")));*/
//        etJenis.setText(b.getString("jenis")+"");
//        etDetail.setText(b.getString("detail")+"");
//
//        /** Returns the View object */
//        return v;
//    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // get view inflater
        View v = getActivity().getLayoutInflater().inflate(R.layout.dialog_tambah_spek,null);

        /** Getting the arguments passed to this fragment. Here we expects the selected item's position as argument */
        Bundle b = getArguments();

        /** Setting the title for the dialog window */
        builder.setTitle(b.getString("modal") +" Spesifikasi Barang");

        /** Getting the reference to the TextView object of the layout */
        EditText etJenis = (EditText) v.findViewById(R.id.etJenisSpek);
        EditText etDetail = (EditText) v.findViewById(R.id.etDetailSpek);

        /** Setting the current time to the TextView object of the layout */
        /** tvJenis.setText(getCurTime(b.getInt("position")));*/
        etJenis.setText(b.getString("jenis")+"");
        etDetail.setText(b.getString("detail")+"");


        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        /** If click the button ok and cancel */
        builder.setView(v)
                // Add action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        //tambah ke arraylist
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        TambahSpek_dialogFragment.this.getDialog().cancel();
                    }
                });

        return builder.create();
    }

}
