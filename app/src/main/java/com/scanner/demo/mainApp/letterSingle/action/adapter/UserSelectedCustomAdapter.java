package com.scanner.demo.mainApp.letterSingle.action.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.scanner.demo.R;
import com.scanner.demo.databinding.ItemSimpleUserBinding;
import com.scanner.demo.mainApp.letterSingle.action.model.UserChoise;
import com.scanner.demo.mainApp.letterSingle.action.onClickEvent.onRemoveChoiseUserClick;

import java.util.List;

public class UserSelectedCustomAdapter extends RecyclerView.Adapter<UserSelectedCustomAdapter.viewHolderUserSelected> {
    Context context;
    List<UserChoise> userChoiseList;
    onRemoveChoiseUserClick onRemoveChoiseUserClick;

    public UserSelectedCustomAdapter(Context context, List<UserChoise> userChoiseList, com.scanner.demo.mainApp.letterSingle.action.onClickEvent.onRemoveChoiseUserClick onRemoveChoiseUserClick) {
        this.context = context;
        this.userChoiseList = userChoiseList;
        this.onRemoveChoiseUserClick = onRemoveChoiseUserClick;
    }

    @NonNull
    @Override
    public viewHolderUserSelected onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        ItemSimpleUserBinding itemSimpleUserBinding = DataBindingUtil.inflate(inflater, R.layout.item_simple_user,parent,false);
        return new viewHolderUserSelected(itemSimpleUserBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolderUserSelected holder, int position) {
        holder.itemSimpleUserBinding.setUserChoise(userChoiseList.get(position));
        holder.itemSimpleUserBinding.removeUserChoised.setOnClickListener(View->{
            onRemoveChoiseUserClick.removeUserChoised(userChoiseList.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return userChoiseList.size();
    }

    public static class viewHolderUserSelected extends RecyclerView.ViewHolder {
        ItemSimpleUserBinding itemSimpleUserBinding;
        public viewHolderUserSelected(@NonNull ItemSimpleUserBinding itemView) {
            super(itemView.getRoot());
            this.itemSimpleUserBinding = itemView;
        }
    }
}
