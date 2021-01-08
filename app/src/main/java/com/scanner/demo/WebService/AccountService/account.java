package com.scanner.demo.WebService.AccountService;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.scanner.demo.CustomClass.AlertDialog;
import com.scanner.demo.CustomClass.MyApplication;
import com.scanner.demo.WebService.APIClient;
import com.scanner.demo.loginPage.model.LoginModelBody;
import com.scanner.demo.loginPage.model.LoginModelResponseRoot;
import com.scanner.demo.mainApp.fileManager.model.FileManagerModelResponseRoot;
import com.scanner.demo.mainApp.kartable.upsertLetter.model.UsersResponseRoot;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class account {
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    //login
    private MutableLiveData<LoginModelResponseRoot> loginModelResponseRootMutableLiveData = new MutableLiveData<>();
    //users
    private MutableLiveData<UsersResponseRoot> usersListRootMutableLiveData = new MutableLiveData<>();
    //file
    private MutableLiveData<FileManagerModelResponseRoot> fileManagerModelResponseRootMutableLiveData = new MutableLiveData<>();
    //other variable
    APIClient apiClient;
    Context context;

    //cons
    public account(Context context) {
        this.context = context;
    }

    //login
    public MutableLiveData<LoginModelResponseRoot> login(String username, String password){
        apiClient = new APIClient();
        compositeDisposable.add(apiClient.LOGIN(new LoginModelBody(username,password))
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<LoginModelResponseRoot>() {
                    @Override
                    public void onSuccess(@NonNull LoginModelResponseRoot loginModelResponseRoot) {
                        if(loginModelResponseRoot.isStatus()) {
                            loginModelResponseRootMutableLiveData.setValue(loginModelResponseRoot);
                        }else{
                            AlertDialog.showAlertDialog(MyApplication.getAppContext(),"خطا در ورود","نام کاربری یا رمز عبور خود را درست وارد کنید");
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        AlertDialog.showAlertDialog(context,"خطا در ورود","نام کاربری یا رمز عبور خود را درست وارد کنید");
                    }
                }));
        return loginModelResponseRootMutableLiveData;
    }

    //getUsers
    public MutableLiveData<UsersResponseRoot> users(){
        apiClient = new APIClient();
        compositeDisposable.add(apiClient.GET_USERS()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<UsersResponseRoot>() {
                    @Override
                    public void onSuccess(@NonNull UsersResponseRoot usersListRoot) {
                        if(usersListRoot.getStatus()) {
                            usersListRootMutableLiveData.setValue(usersListRoot);
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                }));

        return usersListRootMutableLiveData;
    }

    //getUserFiles
    public MutableLiveData<FileManagerModelResponseRoot> files(String From,String To,String FileName,int PageNumber,int PageSize){
        apiClient = new APIClient();
        compositeDisposable.add(apiClient.GET_FILES(null,null,FileName,1,50)
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(new DisposableSingleObserver<FileManagerModelResponseRoot>() {
            @Override
            public void onSuccess(@NonNull FileManagerModelResponseRoot fileManagerModelResponseRoot) {
                fileManagerModelResponseRootMutableLiveData.setValue(fileManagerModelResponseRoot);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }
        }));
        return fileManagerModelResponseRootMutableLiveData;
    }
}
