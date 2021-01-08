package com.scanner.demo.mainApp.letterSingle.viewmodel;

import android.content.Context;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.lifecycle.MutableLiveData;

import com.scanner.demo.BR;
import com.scanner.demo.WebService.Letter.letterService;
import com.scanner.demo.mainApp.letterSingle.model.LetterSingleRoot;
import com.scanner.demo.mainApp.letterSingle.model.data;

public class LetterSinleVM extends BaseObservable {
    //base variable
    private data data;
    private boolean status;
    private String message;
    //main variable
    private LetterSingleRoot letterSingleRoot;
    private String letterId;
    //context and mutable
    private Context context;
    private MutableLiveData<LetterSingleRoot> singleRootMutableLiveData = new MutableLiveData<>();

    //cons
    public LetterSinleVM(Context context, String letterId) {
        this.context = context;
        this.letterId = letterId;
        getSinlgeData();
    }


    private void getSinlgeData() {
        letterService letterService = new letterService(context);
        singleRootMutableLiveData = letterService.getSingleLetter(letterId);
        notifyPropertyChanged(BR.singleRootMutableLiveData);
    }


    //getter and setter
    @Bindable
    public com.scanner.demo.mainApp.letterSingle.model.data getData() {
        return data;
    }

    public void setData(com.scanner.demo.mainApp.letterSingle.model.data data) {
        this.data = data;
        notifyPropertyChanged(com.scanner.demo.BR.data);
    }
    @Bindable
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
        notifyPropertyChanged(com.scanner.demo.BR.status);
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
    public LetterSingleRoot getLetterSingleRoot() {
        return letterSingleRoot;
    }

    public void setLetterSingleRoot(LetterSingleRoot letterSingleRoot) {
        this.letterSingleRoot = letterSingleRoot;
        notifyPropertyChanged(BR.letterSingleRoot);
    }
    @Bindable
    public MutableLiveData<LetterSingleRoot> getSingleRootMutableLiveData() {
        return singleRootMutableLiveData;
    }
    public void setSingleRootMutableLiveData(MutableLiveData<LetterSingleRoot> singleRootMutableLiveData) {
        this.singleRootMutableLiveData = singleRootMutableLiveData;
        notifyPropertyChanged(BR.singleRootMutableLiveData);
    }
}
