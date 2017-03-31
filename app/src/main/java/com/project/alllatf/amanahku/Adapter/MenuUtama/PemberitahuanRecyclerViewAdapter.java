package com.project.alllatf.amanahku.Adapter.MenuUtama;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.project.alllatf.amanahku.Fragment.OnFragmentInteractionListener;
import com.project.alllatf.amanahku.Model.MenuUtama.PemberitahuanModel.PemberitahuanItem;
import com.project.alllatf.amanahku.R;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PemberitahuanItem} and makes a call to the
 * specified {@link OnFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class PemberitahuanRecyclerViewAdapter extends RecyclerView.Adapter<PemberitahuanRecyclerViewAdapter.ViewHolder> {

    private final List<PemberitahuanItem> mValues;
    private final OnFragmentInteractionListener mListener;
    private String TAG = "PemberitahuanRecycleViewAdapter";

    public PemberitahuanRecyclerViewAdapter(List<PemberitahuanItem> items, OnFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_utama_pemberitahuan, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).id);
        holder.mContentView.setText(mValues.get(position).content);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onFragmentInteraction(TAG,holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public PemberitahuanItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
