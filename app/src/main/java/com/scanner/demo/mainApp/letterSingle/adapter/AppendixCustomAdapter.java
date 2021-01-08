package com.scanner.demo.mainApp.letterSingle.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.scanner.demo.R;
import com.scanner.demo.databinding.ItemAppendixBinding;
import com.scanner.demo.mainApp.letterSingle.model.Appendixes;

import java.util.List;

public class AppendixCustomAdapter extends RecyclerView.Adapter<AppendixCustomAdapter.viewHolderAppendix> {
    Context context;
    List<Appendixes> appendixesList;

    public AppendixCustomAdapter(Context context, List<Appendixes> appendixesList) {
        this.context = context;
        this.appendixesList = appendixesList;
    }

    @NonNull
    @Override
    public viewHolderAppendix onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        ItemAppendixBinding appendixBinding = DataBindingUtil.inflate(inflater, R.layout.item_appendix,parent,false);
        return new viewHolderAppendix(appendixBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolderAppendix holder, int position) {
        holder.itemAppendixBinding.setAppendix(appendixesList.get(position));
    }

    @Override
    public int getItemCount() {
        return appendixesList.size();
    }

    public static class viewHolderAppendix extends RecyclerView.ViewHolder {
        ItemAppendixBinding itemAppendixBinding;
        public viewHolderAppendix(@NonNull ItemAppendixBinding itemView) {
            super(itemView.getRoot());
            this.itemAppendixBinding = itemView;
        }
    }
}
