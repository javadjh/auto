package com.scanner.demo.mainApp.fileManager.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.style.AlignmentSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.scanner.demo.CustomClass.fileTypePicker;
import com.scanner.demo.R;
import com.scanner.demo.WebService.FileService.FileService;
import com.scanner.demo.databinding.ItemFileBinding;
import com.scanner.demo.mainApp.fileManager.model.FileList;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FileUserCustomAdapter extends RecyclerView.Adapter<FileUserCustomAdapter.viewHolderFileUser> {
    Context context;
    List<FileList> fileListList;

    public FileUserCustomAdapter(Context context, List<FileList> fileListList) {
        this.context = context;
        this.fileListList = fileListList;
    }

    @NonNull
    @Override
    public viewHolderFileUser onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        ItemFileBinding itemFileBinding = DataBindingUtil.inflate(inflater, R.layout.item_file,parent,false);
        return new viewHolderFileUser(itemFileBinding);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onBindViewHolder(@NonNull viewHolderFileUser holder, int position) {
        holder.itemFileBinding.setFileList(fileListList.get(position));
        holder.itemFileBinding.imageFileType.setImageResource(fileTypePicker.fileTypePickerMethod(context,fileListList.get(position).getFileType()));
        holder.itemFileBinding.cardDownloadFile.setOnClickListener(View->{
            FileService fileService = new FileService(context);
            fileService.getFile(fileListList.get(position).getId(),fileListList.get(position).getTitle(),
                    fileListList.get(position).getFileType());
        });
    }

    @Override
    public int getItemCount() {
        return fileListList.size();
    }

    public static class viewHolderFileUser extends RecyclerView.ViewHolder {
        ItemFileBinding itemFileBinding;
        public viewHolderFileUser(@NonNull ItemFileBinding itemView) {
            super(itemView.getRoot());
            this.itemFileBinding = itemView;
        }
    }
}
