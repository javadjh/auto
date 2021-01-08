package com.scanner.demo.mainApp.letterSingle.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.scanner.demo.R;
import com.scanner.demo.databinding.ItemCopyBinding;
import com.scanner.demo.mainApp.letterSingle.model.Copies;

import java.util.List;

public class CopiesCustomAdapter extends RecyclerView.Adapter<CopiesCustomAdapter.viewHolderCopies> {
     Context context;
     List<Copies> copiesList;

    public CopiesCustomAdapter(Context context, List<Copies> copiesList) {
        this.context = context;
        this.copiesList = copiesList;
    }

    @NonNull
    @Override
    public viewHolderCopies onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        ItemCopyBinding itemCopyBinding = DataBindingUtil.inflate(inflater,R.layout.item_copy,parent,false);
        return new viewHolderCopies(itemCopyBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolderCopies holder, int position) {
        holder.itemAppendixBinding.setCopies(copiesList.get(position));
    }

    @Override
    public int getItemCount() {
        return copiesList.size();
    }

    public static class viewHolderCopies extends RecyclerView.ViewHolder {
        ItemCopyBinding itemAppendixBinding;
        public viewHolderCopies(@NonNull ItemCopyBinding itemView) {
            super(itemView.getRoot());
            this.itemAppendixBinding = itemView;
        }
    }
}
