package com.project.alllatf.amanahku.Fragment.MenuUtama;

/**
 * Created by fachrul on 3/24/17.
 */

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.alllatf.amanahku.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class PembiayaanFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public PembiayaanFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PembiayaanFragment newInstance(int sectionNumber) {
        PembiayaanFragment fragment = new PembiayaanFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.menu_utama_pembiayaan, container, false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            rootView.setNestedScrollingEnabled(true);
        }
        return rootView;
    }
}

