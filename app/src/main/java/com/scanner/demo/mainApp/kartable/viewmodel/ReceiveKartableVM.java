package com.scanner.demo.mainApp.kartable.viewmodel;

import android.content.Context;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.lifecycle.MutableLiveData;

import com.scanner.demo.BR;
import com.scanner.demo.WebService.Letter.letterService;
import com.scanner.demo.mainApp.homePage.model.ReceiveLetterRoot;

public class ReceiveKartableVM extends BaseObservable {
    private com.scanner.demo.mainApp.homePage.model.data data;
    private boolean status;
    private String message;
    private Context context;
    private MutableLiveData<ReceiveLetterRoot> receiveLetterRootMutableLiveData = new MutableLiveData<>();
    private ReceiveLetterRoot receiveLetterRoot;

    public ReceiveKartableVM(Context context) {
        this.context = context;
        getReceivedLetterKartable();
    }

    //logic
    public void getReceivedLetterKartable(){
        letterService letterService = new letterService(context);
        receiveLetterRootMutableLiveData = letterService.getReceivedLetter(null, null, null, null, null, null, 1, 100);
        notifyPropertyChanged(BR.data);
    }


    //getter and setter
    @Bindable
    public com.scanner.demo.mainApp.homePage.model.data getData() {
        return data;
    }

    public void setData(com.scanner.demo.mainApp.homePage.model.data data) {
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
    public MutableLiveData<ReceiveLetterRoot> getReceiveLetterRootMutableLiveData() {
        return receiveLetterRootMutableLiveData;
    }

    public void setReceiveLetterRootMutableLiveData(MutableLiveData<ReceiveLetterRoot> receiveLetterRootMutableLiveData) {
        this.receiveLetterRootMutableLiveData = receiveLetterRootMutableLiveData;
        notifyPropertyChanged(BR.receiveLetterRootMutableLiveData);
    }
    @Bindable
    public ReceiveLetterRoot getReceiveLetterRoot() {
        return receiveLetterRoot;
    }

    public void setReceiveLetterRoot(ReceiveLetterRoot receiveLetterRoot) {
        this.receiveLetterRoot = receiveLetterRoot;
        notifyPropertyChanged(BR.receiveLetterRoot);
    }
}
