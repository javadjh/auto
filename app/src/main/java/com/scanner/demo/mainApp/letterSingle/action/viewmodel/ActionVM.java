package com.scanner.demo.mainApp.letterSingle.action.viewmodel;

import android.content.Context;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.lifecycle.MutableLiveData;

import com.scanner.demo.BR;
import com.scanner.demo.WebService.LetterService.letterService;
import com.scanner.demo.mainApp.kartable.upsertLetter.model.UpsertResponse;
import com.scanner.demo.mainApp.letterSingle.action.model.ActionBody;

    public class ActionVM extends BaseObservable {
    private MutableLiveData<UpsertResponse> upsertResponseMutableLiveData = new MutableLiveData<>();
    private Context context;

    public ActionVM(Context context) {
        this.context = context;
    }

    public void sendAction(ActionBody actionBody){
        letterService letterService = new letterService(context);
        upsertResponseMutableLiveData = letterService.action(actionBody);
    }

    //getter and setter
    @Bindable
    public MutableLiveData<UpsertResponse> getUpsertResponseMutableLiveData() {
        return upsertResponseMutableLiveData;
    }

    public void setUpsertResponseMutableLiveData(MutableLiveData<UpsertResponse> upsertResponseMutableLiveData) {
        this.upsertResponseMutableLiveData = upsertResponseMutableLiveData;
        notifyPropertyChanged(BR.upsertResponseMutableLiveData);
    }
}
