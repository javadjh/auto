package com.scanner.demo.mainApp.kartable.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.scanner.demo.R;
import com.scanner.demo.databinding.ItemDraftBinding;
import com.scanner.demo.mainApp.kartable.model.DraftList;

import java.util.List;

public class DraftLetterCustomAdapter extends RecyclerView.Adapter<DraftLetterCustomAdapter.viewHolderDraftLetter> {
    Context context;
    List<DraftList> draftListList;

    public DraftLetterCustomAdapter(Context context, List<DraftList> draftListList) {
        this.context = context;
        this.draftListList = draftListList;
    }

    @NonNull
    @Override
    public viewHolderDraftLetter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        ItemDraftBinding itemDraftBinding = DataBindingUtil.inflate(inflater, R.layout.item_draft,parent,false);
        return new viewHolderDraftLetter(itemDraftBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolderDraftLetter holder, int position) {
        holder.itemDraftBinding.setDraftList(draftListList.get(position));
        holder.itemDraftBinding.descriptionDraftHTML.setHtml(draftListList.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return draftListList.size();
    }

    public static class viewHolderDraftLetter extends RecyclerView.ViewHolder {
        ItemDraftBinding itemDraftBinding;
        public viewHolderDraftLetter(@NonNull ItemDraftBinding itemView) {
            super(itemView.getRoot());
            this.itemDraftBinding = itemView;
        }
    }
}
