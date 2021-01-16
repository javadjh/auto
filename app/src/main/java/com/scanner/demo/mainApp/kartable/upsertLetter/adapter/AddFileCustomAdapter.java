package com.scanner.demo.mainApp.kartable.upsertLetter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.scanner.demo.R;
import com.scanner.demo.databinding.ItemAddFileBinding;
import com.scanner.demo.databinding.ItemCopiesBinding;
import com.scanner.demo.mainApp.kartable.upsertLetter.interfaceEvent.onClickAddFile;
import com.scanner.demo.mainApp.kartable.upsertLetter.model.EventAddFile;

import java.util.List;

public class AddFileCustomAdapter extends RecyclerView.Adapter<AddFileCustomAdapter.viewHolderAddFile> {
    Context context;
    List<EventAddFile> eventAddFileList;
    onClickAddFile onClickAddFile;

    public AddFileCustomAdapter(Context context, List<EventAddFile> eventAddFileList, com.scanner.demo.mainApp.kartable.upsertLetter.interfaceEvent.onClickAddFile onClickAddFile) {
        this.context = context;
        this.eventAddFileList = eventAddFileList;
        this.onClickAddFile = onClickAddFile;
    }


    @NonNull
    @Override
    public viewHolderAddFile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        ItemAddFileBinding itemAddFileBinding = DataBindingUtil.inflate(inflater, R.layout.item_add_file,parent,false);
        return new viewHolderAddFile(itemAddFileBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolderAddFile holder, int position) {
        holder.itemAddFileBinding.setEventAddFile(eventAddFileList.get(position));
        holder.itemAddFileBinding.removeItemCopies.setOnClickListener(View->{
            onClickAddFile.getFileAction(eventAddFileList.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return eventAddFileList.size();
    }

    public static class viewHolderAddFile extends RecyclerView.ViewHolder {
        ItemAddFileBinding itemAddFileBinding;
        public viewHolderAddFile(@NonNull ItemAddFileBinding itemView) {
            super(itemView.getRoot());
            this.itemAddFileBinding = itemView;
        }
    }
}
