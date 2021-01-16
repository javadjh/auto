package com.scanner.demo.mainApp.letterSingle.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.scanner.demo.R;
import com.scanner.demo.databinding.ItemTrackBinding;
import com.scanner.demo.mainApp.letterSingle.model.TrackDataLetter;

import java.util.List;

public class TrackCustomAdapter extends RecyclerView.Adapter<TrackCustomAdapter.viewHolderTrack> {
    List<TrackDataLetter> trackDataLetters;
    Context context;

    public TrackCustomAdapter(List<TrackDataLetter> trackDataLetters, Context context) {
        this.trackDataLetters = trackDataLetters;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolderTrack onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        ItemTrackBinding itemTrackBinding = DataBindingUtil.inflate(inflater, R.layout.item_track,parent,false);
        return new viewHolderTrack(itemTrackBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolderTrack holder, int position) {
        holder.itemTrackBinding.setData(trackDataLetters.get(position));
        holder.itemTrackBinding.recyReceiverTrack.setAdapter(new TrackUsersCustomAdapter(context,trackDataLetters.get(position).getReceivers()));
    }

    @Override
    public int getItemCount() {
        return trackDataLetters.size();
    }

    public static class viewHolderTrack extends RecyclerView.ViewHolder {
        ItemTrackBinding itemTrackBinding;
        public viewHolderTrack(@NonNull ItemTrackBinding itemView) {
            super(itemView.getRoot());
            this.itemTrackBinding = itemView;
        }
    }
}
