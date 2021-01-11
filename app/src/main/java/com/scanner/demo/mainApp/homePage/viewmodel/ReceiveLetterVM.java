package com.scanner.demo.mainApp.homePage.viewmodel;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.lifecycle.MutableLiveData;

import com.scanner.demo.BR;
import com.scanner.demo.mainApp.homePage.model.ReceiveLetterRoot;
import com.scanner.demo.WebService.Letter.letterService;

public class ReceiveLetterVM extends BaseObservable {
    private com.scanner.demo.mainApp.homePage.model.data data;
    private boolean status;
    private String message;
    private Context context;
    private MutableLiveData<ReceiveLetterRoot> receiveLetterRootMutableLiveData = new MutableLiveData<>();
    private ReceiveLetterRoot receiveLetterRoot;
    private String nameAndLastName;
    private String role;

    //init VM
    public ReceiveLetterVM(Context context) {
        this.context = context;
        getReceivedLetter();
        setName();
    }

    private void setName() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("information",Context.MODE_PRIVATE );
        nameAndLastName = sharedPreferences.getString("fullName","");
        role = sharedPreferences.getString("rolse","");

    }

    //logic

    //setPageData
    public void getReceivedLetter(){
        letterService letterService = new letterService(context);
        receiveLetterRootMutableLiveData = letterService.getReceivedLetter(null, null, null, null, null, null, null);
        notifyPropertyChanged(BR.data);
    }

    //getter and setter
    @Bindable
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
        notifyPropertyChanged(BR.role);
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ReceiveLetterRoot getReceiveLetterRoot() {
        return receiveLetterRoot;
    }

    public void setReceiveLetterRoot(ReceiveLetterRoot receiveLetterRoot) {
        this.receiveLetterRoot = receiveLetterRoot;
    }
    @Bindable
    public String getNameAndLastName() {
        return nameAndLastName;
    }

    public void setNameAndLastName(String nameAndLastName) {
        this.nameAndLastName = nameAndLastName;
        notifyPropertyChanged(BR.nameAndLastName);
    }

    public MutableLiveData<ReceiveLetterRoot> getReceiveLetterRootMutableLiveData() {
        return receiveLetterRootMutableLiveData;
    }

    public void setReceiveLetterRootMutableLiveData(MutableLiveData<ReceiveLetterRoot> receiveLetterRootMutableLiveData) {
        this.receiveLetterRootMutableLiveData = receiveLetterRootMutableLiveData;
    }
    @Bindable
    public com.scanner.demo.mainApp.homePage.model.data getData() {
        return data;
    }

    public void setData(com.scanner.demo.mainApp.homePage.model.data data) {
        this.data = data;
        notifyPropertyChanged(BR.data);
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
