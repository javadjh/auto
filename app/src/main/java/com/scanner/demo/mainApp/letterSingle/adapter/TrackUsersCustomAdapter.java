package com.scanner.demo.mainApp.letterSingle.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.scanner.demo.R;
import com.scanner.demo.databinding.ItemReceiveBinding;
import com.scanner.demo.mainApp.letterSingle.model.Receivers;

import java.util.List;

public class TrackUsersCustomAdapter extends RecyclerView.Adapter<TrackUsersCustomAdapter.viewHolderTrackUsers> {
    Context context;
    List<Receivers> receiversList;

    public TrackUsersCustomAdapter(Context context, List<Receivers> receiversList) {
        this.context = context;
        this.receiversList = receiversList;
    }

    @NonNull
    @Override
    public viewHolderTrackUsers onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        ItemReceiveBinding itemReceiveBinding = DataBindingUtil.inflate(inflater, R.layout.item_receive,parent,false);
        return new viewHolderTrackUsers(itemReceiveBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolderTrackUsers holder, int position) {
        holder.itemReceiveBinding.setReceivers(receiversList.get(position));
    }

    @Override
    public int getItemCount() {
        return receiversList.size();
    }

    public static class viewHolderTrackUsers extends RecyclerView.ViewHolder {
        ItemReceiveBinding itemReceiveBinding;
        public viewHolderTrackUsers(@NonNull ItemReceiveBinding itemView) {
            super(itemView.getRoot());
            this.itemReceiveBinding = itemView;
        }
    }
}
