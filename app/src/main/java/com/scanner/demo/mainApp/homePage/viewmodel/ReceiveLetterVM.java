package com.scanner.demo.mainApp.homePage.viewmodel;

import android.content.Context;

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

    //init VM
    public ReceiveLetterVM(Context context) {
        this.context = context;
        getReceivedLetter();
    }

    //logic

    //setPageData
    public void getReceivedLetter(){
        letterService letterService = new letterService(context);
        receiveLetterRootMutableLiveData = letterService.getReceivedLetter(null, null, null, null, null, null, 1, 100);
        notifyPropertyChanged(BR.data);
    }

    //getter and setter

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
