package com.scanner.demo.mainApp.homePage.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.scanner.demo.R;
import com.scanner.demo.databinding.ItemLetterBinding;
import com.scanner.demo.mainApp.homePage.clickEvent.onClickLetterListener;
import com.scanner.demo.mainApp.homePage.model.ListLetter;
import com.scanner.demo.mainApp.homePage.view.HomePageFragmentDirections;

import org.sufficientlysecure.htmltextview.HtmlAssetsImageGetter;
import org.sufficientlysecure.htmltextview.HtmlResImageGetter;

import java.util.List;

public class ReceiveLetterCustomAdapter extends RecyclerView.Adapter<ReceiveLetterCustomAdapter.viewHolderReceiveLetter> {
    List<ListLetter> listReceive ;
    Context context;
    onClickLetterListener onClickLetterListener;

    public ReceiveLetterCustomAdapter(List<ListLetter> listReceive, Context context, com.scanner.demo.mainApp.homePage.clickEvent.onClickLetterListener onClickLetterListener) {
        this.listReceive = listReceive;
        this.context = context;
        this.onClickLetterListener = onClickLetterListener;
    }

    @NonNull
    @Override
    public viewHolderReceiveLetter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        ItemLetterBinding itemLetterBinding = DataBindingUtil.inflate(inflater, R.layout.item_letter,parent,false);
        return new viewHolderReceiveLetter(itemLetterBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolderReceiveLetter holder, int position) {
        holder.itemLetterBinding.setListReceiveLetter(listReceive.get(position));
        holder.itemLetterBinding.contextLetter.setHtml(listReceive.get(position).getContent());
        if(listReceive.get(position).isObservationStatus()){
            holder.itemLetterBinding.cardLetter.setCardBackgroundColor(context.getResources().getColor(R.color.lightBlack));
        }else{
            holder.itemLetterBinding.cardLetter.setCardBackgroundColor(context.getResources().getColor(R.color.purple));
        }
        holder.itemLetterBinding.cardLetter.setOnClickListener(View -> {
            onClickLetterListener.onClickLetterListenetAdapter(listReceive.get(position).getId(),listReceive.get(position).getActionId());
        });
    }

    @Override
    public int getItemCount() {
        return listReceive.size();
    }

    public static class viewHolderReceiveLetter extends RecyclerView.ViewHolder {
        ItemLetterBinding itemLetterBinding;
        public viewHolderReceiveLetter(@NonNull ItemLetterBinding itemView) {
            super(itemView.getRoot());
            this.itemLetterBinding = itemView;
        }
    }
}
