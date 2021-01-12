package com.scanner.demo.mainApp.letterSingle.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TrackCustomAdapter extends RecyclerView.Adapter<TrackCustomAdapter.viewHolderTrack> {
    @NonNull
    @Override
    public viewHolderTrack onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolderTrack holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class viewHolderTrack extends RecyclerView.ViewHolder {
        public viewHolderTrack(@NonNull View itemView) {
            super(itemView);
        }
    }
}
