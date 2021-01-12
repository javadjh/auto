package com.scanner.demo.mainApp.kartable.viewmodel;

import android.content.Context;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.lifecycle.MutableLiveData;

import com.scanner.demo.BR;
import com.scanner.demo.WebService.LetterService.letterService;
import com.scanner.demo.mainApp.homePage.model.ReceiveLetterRoot;

public class ReceiveKartableVM extends BaseObservable {
    private com.scanner.demo.mainApp.homePage.model.data data;
    private boolean status;
    private String message;
    private Context context;
    private MutableLiveData<ReceiveLetterRoot> receiveLetterRootMutableLiveData = new MutableLiveData<>();
    private ReceiveLetterRoot receiveLetterRoot;
    String title ,senderName,urgency, from, to ,confidentiality;
    Boolean notObserved;


    public ReceiveKartableVM(Context context, String title, String senderName, String urgency, String from, String to, Boolean notObserved,String confidentiality) {
        this.context = context;
        this.title = title;
        this.senderName = senderName;
        this.urgency = urgency;
        this.from = from;
        this.to = to;
        this.notObserved = notObserved;
        this.confidentiality = confidentiality;
        getReceivedLetterKartable(title ,senderName,urgency, from, to ,notObserved,confidentiality);
    }

    //logic
    public void getReceivedLetterKartable(String title,String senderName,String urgency,String from,String to,Boolean notObserved,String confidentiality){
        letterService letterService = new letterService(context);
        receiveLetterRootMutableLiveData = letterService.getReceivedLetter(title, senderName, urgency, from, to, notObserved,confidentiality);
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
