package com.scanner.demo.mainApp.kartable.viewmodel;

import android.content.Context;
import android.widget.TextView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.Navigation;

import com.scanner.demo.BR;
import com.scanner.demo.R;
import com.scanner.demo.WebService.LetterService.letterService;
import com.scanner.demo.mainApp.homePage.model.ReceiveLetterRoot;
import com.scanner.demo.mainApp.kartable.searchKartable.model.OnEventListennerSend;

public class SendKartableVM extends BaseObservable {
    //modelVariable
    private com.scanner.demo.mainApp.homePage.model.data data;
    private boolean status;
    private String message;
    //otherVariable For VM
    private Context context;
    private MutableLiveData<ReceiveLetterRoot> sendLetterRootMutableLiveData = new MutableLiveData<>();
    private ReceiveLetterRoot sendLetterRoot;

    //searchValue
    String title, receiverRole, receiverName, confidentiality, urgency,from,to;

    public SendKartableVM(Context context, String title, String receiverRole, String receiverName, String confidentiality, String urgency, String from, String to) {
        this.context = context;
        this.title = title;
        this.receiverRole = receiverRole;
        this.receiverName = receiverName;
        this.confidentiality = confidentiality;
        this.urgency = urgency;
        this.from = from;
        this.to = to;
        getSendLetter(title, receiverRole, receiverName, confidentiality, urgency,from,to);
    }

    //logic
    private void getSendLetter(String title, String receiverRole, String receiverName, String confidentiality, String urgency, String from, String to) {
        letterService letterService = new letterService(context);
        sendLetterRootMutableLiveData = letterService.getSendLetter(title, receiverRole, receiverName, confidentiality, urgency,from,to);
        notifyPropertyChanged(BR.sendLetterRootMutableLiveData);
    }

    public void sendToSearch(TextView textView){
        Navigation.findNavController(textView).navigate(R.id.action_kartableFragment_to_sendSearchFragment);
    }

    //getter and setter
    @Bindable
    public com.scanner.demo.mainApp.homePage.model.data getData() {
        return data;
    }

    public void setData(com.scanner.demo.mainApp.homePage.model.data data) {
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
        notifyPropertyChanged(com.scanner.demo.BR.message);
    }
    @Bindable
    public MutableLiveData<ReceiveLetterRoot> getSendLetterRootMutableLiveData() {
        return sendLetterRootMutableLiveData;
    }

    public void setSendLetterRootMutableLiveData(MutableLiveData<ReceiveLetterRoot> sendLetterRootMutableLiveData) {
        this.sendLetterRootMutableLiveData = sendLetterRootMutableLiveData;
        notifyPropertyChanged(com.scanner.demo.BR.sendLetterRootMutableLiveData);
    }
    @Bindable
    public ReceiveLetterRoot getSendLetterRoot() {
        return sendLetterRoot;
    }

    public void setSendLetterRoot(ReceiveLetterRoot sendLetterRoot) {
        this.sendLetterRoot = sendLetterRoot;
        notifyPropertyChanged(BR.sendLetterRoot);
    }
}
