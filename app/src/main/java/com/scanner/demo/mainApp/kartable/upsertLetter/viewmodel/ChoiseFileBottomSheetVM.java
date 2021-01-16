package com.scanner.demo.mainApp.kartable.upsertLetter.viewmodel;

import android.content.Context;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.scanner.demo.BR;
import com.scanner.demo.R;
import com.scanner.demo.WebService.AccountService.account;
import com.scanner.demo.mainApp.fileManager.model.FileManagerModelResponseRoot;
import com.scanner.demo.mainApp.fileManager.model.UserFileList;
import com.scanner.demo.mainApp.kartable.upsertLetter.view.ChoiseFileBootomSheetDirections;

public class ChoiseFileBottomSheetVM extends BaseObservable {
    //main Variable model
    private UserFileList data;
    private boolean status;
    private String message;
    //other Variable
    private MutableLiveData<FileManagerModelResponseRoot> fileManagerModelResponseRootMutableLiveData = new MutableLiveData<>();
    private Context context;
    private String fileName;

    //cons
    public ChoiseFileBottomSheetVM(Context context, String fileName) {
        this.context = context;
        this.fileName = fileName;
        Log.i("rrrrr"," . "+fileName);
        getFileUser(fileName);
    }

    //logic
    private void getFileUser(String fileName) {
        account account = new account(context);
        fileManagerModelResponseRootMutableLiveData = account.files(null,null,fileName,1,50);
    }


    //getter and Setter
    @Bindable
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
        notifyPropertyChanged(BR.fileName);
    }

    @Bindable
    public UserFileList getData() {
        return data;
    }

    public void setData(UserFileList data) {
        this.data = data;
        notifyPropertyChanged(BR.data);
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
        notifyPropertyChanged(BR.fileManagerModelResponseRootMutableLiveData);
    }
    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
