package com.scanner.demo.mainApp.kartable.upsertLetter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.scanner.demo.R;
import com.scanner.demo.databinding.ItemUsersBinding;
import com.scanner.demo.mainApp.kartable.upsertLetter.interfaceEvent.onclick;
import com.scanner.demo.mainApp.kartable.upsertLetter.model.UsersDataList;

import java.util.List;

public class UsersCustomAdapter extends RecyclerView.Adapter<UsersCustomAdapter.viewHolderUsers> {
    List<UsersDataList> usersDataLists;
    Context context;
    onclick onclick;

    public UsersCustomAdapter(List<UsersDataList> usersDataLists, Context context, com.scanner.demo.mainApp.kartable.upsertLetter.interfaceEvent.onclick onclick) {
        this.usersDataLists = usersDataLists;
        this.context = context;
        this.onclick = onclick;
    }

    @NonNull
    @Override
    public viewHolderUsers onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        ItemUsersBinding itemUsersBinding = DataBindingUtil.inflate(inflater, R.layout.item_users,parent,false);
        return new viewHolderUsers(itemUsersBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolderUsers holder, int position) {
        holder.usersBinding.setUsersDataList(usersDataLists.get(position));
        holder.usersBinding.cardUsers.setOnClickListener(View->{
            onclick.userInformation(usersDataLists.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return usersDataLists.size();
    }

    public static class viewHolderUsers extends RecyclerView.ViewHolder {
        ItemUsersBinding usersBinding;
        public viewHolderUsers(@NonNull ItemUsersBinding itemView) {
            super(itemView.getRoot());
            this.usersBinding = itemView;
        }
    }
}
