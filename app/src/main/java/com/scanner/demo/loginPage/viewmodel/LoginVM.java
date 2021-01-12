package com.scanner.demo.loginPage.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

import com.scanner.demo.BR;
import com.scanner.demo.CustomClass.AlertDialog;
import com.scanner.demo.mainApp.MainApp;
import com.scanner.demo.WebService.AccountService.account;
import com.scanner.demo.loginPage.model.LoginModelResponseRoot;

public class LoginVM extends BaseObservable {
    private String username = "";
    private String password = "";
    private Context context;
    private account account;

    public LoginVM(Context context) {
        this.context = context;
    }

    //Logic
    //click Event Login
    public void getUserInformationForLogin (String username , String password){
        if (username.length() >=3) {
            if(password.length()>=3) {
                account = new account(context);
                account.login(username, password).observe((LifecycleOwner) context, new Observer<LoginModelResponseRoot>() {
                    @Override
                    public void onChanged(LoginModelResponseRoot loginModelResponseRoot) {
                        SharedPreferences sharedPreferences = context.getSharedPreferences("information",Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("rolse",loginModelResponseRoot.getData().getRoles().toString());
                        editor.putString("userId",loginModelResponseRoot.getData().getUserId());
                        editor.putString("username",loginModelResponseRoot.getData().getUsername());
                        editor.putString("fullName",loginModelResponseRoot.getData().getFullName());
                        editor.putString("thumbnail",loginModelResponseRoot.getData().getThumbnail());
                        editor.apply();
                        if(loginModelResponseRoot.getData().getToken().isEmpty()){
                            AlertDialog.showAlertDialog(context,"خطا در ورود","خطای ناشناخته رخ داده است");
                        }else{
                            context.startActivity(new Intent(LoginVM.this.context, MainApp.class));
                        }
                    }
                });
            }else{
                AlertDialog.showAlertDialog(context,"خطا در ورود","لطفا رمز عبور خود را وارد کنید");
            }
        }else{
            AlertDialog.showAlertDialog(context,"خطا در ورود","لطفا نام کاربری خود را وارد کنید");
        }
    }


    //getter And Setter
    @Bindable
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        notifyPropertyChanged(BR.username);
    }
    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }
}
