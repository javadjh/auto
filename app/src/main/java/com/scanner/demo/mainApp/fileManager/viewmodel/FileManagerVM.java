package com.scanner.demo.mainApp.fileManager.viewmodel;

import android.content.Context;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.library.baseAdapters.BR;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.Navigation;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.scanner.demo.R;
import com.scanner.demo.WebService.AccountService.account;
import com.scanner.demo.mainApp.fileManager.model.FileManagerModelResponseRoot;
import com.scanner.demo.mainApp.fileManager.model.UserFileList;

import java.util.List;

public class FileManagerVM extends BaseObservable {
    //main Variable model
    private UserFileList data;
    private boolean status;
    private String message;
    //other Variable
    private MutableLiveData<FileManagerModelResponseRoot> fileManagerModelResponseRootMutableLiveData = new MutableLiveData<>();
    private Context context;

    //cons
    public FileManagerVM(Context context) {
        this.context = context;
        getFiles();
    }


    //logic
    private void getFiles() {
        account account = new account(context);
        fileManagerModelResponseRootMutableLiveData = account.files(null,null,null,1,50);
    }



    //getter and setter

    @Bindable
    public UserFileList getData() {
        return data;
    }

    public void setData(UserFileList data) {
        this.data = data;
        notifyPropertyChanged(BR.data);
    }
    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
    @Bindable
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
        notifyPropertyChanged(BR.status);
    }
    @Bindable
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        notifyPropertyChanged(BR.message);
    }
    @Bindable
    public MutableLiveData<FileManagerModelResponseRoot> getFileManagerModelResponseRootMutableLiveData() {
        return fileManagerModelResponseRootMutableLiveData;
    }

    public void setFileManagerModelResponseRootMutableLiveData(MutableLiveData<FileManagerModelResponseRoot> fileManagerModelResponseRootMutableLiveData) {
        this.fileManagerModelResponseRootMutableLiveData = fileManagerModelResponseRootMutableLiveData;
        notifyPropertyChanged(com.scanner.demo.BR.fileManagerModelResponseRootMutableLiveData);
    }
}
