package com.scanner.demo.mainApp.kartable.upsertLetter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.scanner.demo.CustomClass.fileTypePicker;
import com.scanner.demo.R;
import com.scanner.demo.databinding.ItemChoiseFileBinding;
import com.scanner.demo.mainApp.fileManager.model.FileList;
import com.scanner.demo.mainApp.kartable.upsertLetter.interfaceEvent.onClickAddFile;
import com.scanner.demo.mainApp.kartable.upsertLetter.model.EventAddFile;

import java.util.List;

public class ChoiseFileCustomAdapter extends RecyclerView.Adapter<ChoiseFileCustomAdapter.viewHolderChoiseFile> {
    Context context;
    List<FileList> fileListList;
    onClickAddFile onClickAddFile;

    public ChoiseFileCustomAdapter(Context context, List<FileList> fileListList, com.scanner.demo.mainApp.kartable.upsertLetter.interfaceEvent.onClickAddFile onClickAddFile) {
        this.context = context;
        this.fileListList = fileListList;
        this.onClickAddFile = onClickAddFile;
    }


    @NonNull
    @Override
    public viewHolderChoiseFile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        ItemChoiseFileBinding itemChoiseFileBinding = DataBindingUtil.inflate(inflater, R.layout.item_choise_file,parent,false);
        return new viewHolderChoiseFile(itemChoiseFileBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolderChoiseFile holder, int position) {
        holder.itemChoiseFileBinding.setFileList(fileListList.get(position));
        holder.itemChoiseFileBinding.fileTypeImage.setImageResource(fileTypePicker.fileTypePickerMethod(context,fileListList.get(position).getFileType()));
        holder.itemChoiseFileBinding.cardChoiseFile.setOnClickListener(View->{
            onClickAddFile.getFileAction(new EventAddFile(
                    fileListList.get(position).getTitle(),
                    fileListList.get(position).getId(),
                    true
            ));
        });
    }

    @Override
    public int getItemCount() {
        return fileListList.size();
    }

    public static class viewHolderChoiseFile extends RecyclerView.ViewHolder {
        ItemChoiseFileBinding itemChoiseFileBinding;
        public viewHolderChoiseFile(@NonNull ItemChoiseFileBinding itemView) {
            super(itemView.getRoot());
            this.itemChoiseFileBinding = itemView;
        }
    }
}
