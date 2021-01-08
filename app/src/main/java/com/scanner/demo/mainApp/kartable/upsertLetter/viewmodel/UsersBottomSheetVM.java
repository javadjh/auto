package com.scanner.demo.mainApp.kartable.upsertLetter.viewmodel;

import android.content.Context;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.lifecycle.MutableLiveData;

import com.scanner.demo.BR;
import com.scanner.demo.WebService.AccountService.account;
import com.scanner.demo.mainApp.kartable.upsertLetter.model.UsersDataList;
import com.scanner.demo.mainApp.kartable.upsertLetter.model.UsersResponseRoot;

import java.util.List;

public class UsersBottomSheetVM extends BaseObservable {
    private List<UsersDataList> data;
    private Boolean status;
    private String message;
    private MutableLiveData<UsersResponseRoot> usersResponseRootMutableLiveData = new MutableLiveData<>();
    private Context context;

    //cons
    public UsersBottomSheetVM(Context context) {
        this.context = context;
        getUsersData();
    }


    //logic
    private void getUsersData() {
        account account = new account(context);
        usersResponseRootMutableLiveData = account.users();
        notifyPropertyChanged(BR.usersResponseRootMutableLiveData);
    }



    //getter and setter
    @Bindable
    public List<UsersDataList> getData() {
        return data;
    }

    public void setData(List<UsersDataList> data) {
        this.data = data;
        notifyPropertyChanged(BR.data);
    }
    @Bindable
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
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
    public MutableLiveData<UsersResponseRoot> getUsersResponseRootMutableLiveData() {
        return usersResponseRootMutableLiveData;
    }

    public void setUsersResponseRootMutableLiveData(MutableLiveData<UsersResponseRoot> usersResponseRootMutableLiveData) {
        this.usersResponseRootMutableLiveData = usersResponseRootMutableLiveData;
        notifyPropertyChanged(BR.usersResponseRootMutableLiveData);
    }
}
