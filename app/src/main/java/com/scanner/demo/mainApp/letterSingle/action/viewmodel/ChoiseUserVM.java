package com.scanner.demo.mainApp.letterSingle.action.viewmodel;

import android.content.Context;

import androidx.databinding.BaseObservable;
import androidx.lifecycle.MutableLiveData;

import com.scanner.demo.WebService.AccountService.account;
import com.scanner.demo.mainApp.kartable.upsertLetter.model.UsersDataList;
import com.scanner.demo.mainApp.kartable.upsertLetter.model.UsersResponseRoot;

import java.util.List;

public class ChoiseUserVM extends BaseObservable {
    //Main variable
    private List<UsersDataList> data;
    private Boolean status;
    private String message;

    //other Variable
    private MutableLiveData<UsersResponseRoot> usersResponseRootMutableLiveData = new MutableLiveData<>();
    private Context context;

    public ChoiseUserVM(Context context) {
        this.context = context;
        getUsers();
    }

    private void getUsers() {
        account account = new account(context);
        usersResponseRootMutableLiveData = account.users();
    }

    //getter and setter

    public List<UsersDataList> getData() {
        return data;
    }

    public void setData(List<UsersDataList> data) {
        this.data = data;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MutableLiveData<UsersResponseRoot> getUsersResponseRootMutableLiveData() {
        return usersResponseRootMutableLiveData;
    }

    public void setUsersResponseRootMutableLiveData(MutableLiveData<UsersResponseRoot> usersResponseRootMutableLiveData) {
        this.usersResponseRootMutableLiveData = usersResponseRootMutableLiveData;
    }
}
