package com.scanner.demo.mainApp.kartable.viewmodel;

import android.content.Context;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.lifecycle.MutableLiveData;
import com.scanner.demo.BR;
import com.scanner.demo.WebService.Letter.letterService;
import com.scanner.demo.mainApp.kartable.model.DraftResponseRoot;

public class DraftKartableVM extends BaseObservable {
    //model
    private com.scanner.demo.mainApp.kartable.model.data data;
    private boolean status;
    private String message;
    //VM variable
    private MutableLiveData<DraftResponseRoot> draftResponseRootMutableLiveData = new MutableLiveData<>();
    private Context context;

    public DraftKartableVM(Context context) {
        this.context = context;
        getDraftLetter();
    }

    private void getDraftLetter() {
        letterService letterService = new letterService(context);
        draftResponseRootMutableLiveData = letterService.getDraftLetter();
        notifyPropertyChanged(BR.draftResponseRootMutableLiveData);
    }

    //getter and setter
    @Bindable
    public com.scanner.demo.mainApp.kartable.model.data getData() {
        return data;
    }

    public void setData(com.scanner.demo.mainApp.kartable.model.data data) {
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
    public MutableLiveData<DraftResponseRoot> getDraftResponseRootMutableLiveData() {
        return draftResponseRootMutableLiveData;
    }

    public void setDraftResponseRootMutableLiveData(MutableLiveData<DraftResponseRoot> draftResponseRootMutableLiveData) {
        this.draftResponseRootMutableLiveData = draftResponseRootMutableLiveData;
        notifyPropertyChanged(BR.draftResponseRootMutableLiveData);
    }
}
