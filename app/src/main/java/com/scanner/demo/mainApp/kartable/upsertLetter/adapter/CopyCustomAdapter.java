package com.scanner.demo.mainApp.kartable.upsertLetter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.scanner.demo.R;
import com.scanner.demo.databinding.ItemCopiesBinding;
import com.scanner.demo.mainApp.kartable.upsertLetter.interfaceEvent.onRemoveCopy;
import com.scanner.demo.mainApp.kartable.upsertLetter.interfaceEvent.onclick;
import com.scanner.demo.mainApp.kartable.upsertLetter.model.CopiesList;

import java.util.List;

public class CopyCustomAdapter extends RecyclerView.Adapter<CopyCustomAdapter.viewHolderCopy> {
    Context context;
    List<CopiesList> copiesLists;
    onRemoveCopy onclick;

    public CopyCustomAdapter(Context context, List<CopiesList> copiesLists, onRemoveCopy onclick) {
        this.context = context;
        this.copiesLists = copiesLists;
        this.onclick = onclick;
    }

    @NonNull
    @Override
    public viewHolderCopy onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        ItemCopiesBinding itemCopiesBinding = DataBindingUtil.inflate(inflater, R.layout.item_copies,parent,false);
        return new viewHolderCopy(itemCopiesBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolderCopy holder, int position) {
        holder.itemCopiesBinding.setCopiesList(copiesLists.get(position));
        holder.itemCopiesBinding.removeItemCopies.setOnClickListener(View ->{
            onclick.copyInformation(copiesLists.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return copiesLists.size();
    }

    public static class viewHolderCopy extends RecyclerView.ViewHolder {
        ItemCopiesBinding itemCopiesBinding;
        public viewHolderCopy(@NonNull ItemCopiesBinding itemView) {
            super(itemView.getRoot());
            this.itemCopiesBinding = itemView;
        }
    }
}
