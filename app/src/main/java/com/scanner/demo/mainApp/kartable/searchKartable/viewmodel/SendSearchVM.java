package com.scanner.demo.mainApp.kartable.searchKartable.viewmodel;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.navigation.Navigation;

import com.jaredrummler.materialspinner.MaterialSpinner;
import com.scanner.demo.BR;
import com.scanner.demo.CustomClass.dateSorting;
import com.scanner.demo.CustomClass.onClickEvent.onClickgetDate;
import com.scanner.demo.R;
import com.scanner.demo.mainApp.kartable.searchKartable.model.OnEventListennerSend;

import java.util.ArrayList;
import java.util.List;

public class SendSearchVM extends BaseObservable {
    //searchValueVariable
    private String title;
    private String receiverRole;
    private String receiverName;
    private String confidentiality;
    private String urgency;
    private String from;
    private String to;

    //logic
    public void getFromDate(TextView textView){
        dateSorting dateSorting = new dateSorting(textView.getContext(), new onClickgetDate() {
            @Override
            public void getDate(String date) {
                from = date;
                notifyPropertyChanged(BR.from);
            }
        });
        dateSorting.fromDate();
        notifyPropertyChanged(BR.from);
    }

    public void getToDate(TextView textView){
        dateSorting dateSorting = new dateSorting(textView.getContext(), new onClickgetDate() {
            @Override
            public void getDate(String date) {
                to = date;
                notifyPropertyChanged(BR.to);
            }
        });
        dateSorting.toDate();
        notifyPropertyChanged(BR.to);
    }

    public void setConfidentialitySpinner(MaterialSpinner materialSpinner,String hint){
        List<String> listConfidentailyEnum = new ArrayList<>();
        listConfidentailyEnum.add("NORMAL");
        listConfidentailyEnum.add("SECRET");
        listConfidentailyEnum.add("TOP_SECRET");
        listConfidentailyEnum.add("TOTALLY_SECRET");
        List<String> listConfidentaily = new ArrayList<>();
        listConfidentaily.add("عادی");
        listConfidentaily.add("محرمانه");
        listConfidentaily.add("سری");
        listConfidentaily.add("به کلی سری");
        materialSpinner.setHint(hint);
        materialSpinner.setItems(listConfidentaily);
        materialSpinner.setOnItemSelectedListener((view, position, id, item) -> confidentiality = listConfidentailyEnum.get(position));
    }

    public void setUrgencyData(RadioButton urgentRB , RadioButton normalRB){
        if(urgentRB.isChecked()){
            urgency = "URGENT";
        }
        if(normalRB.isChecked()){
            urgency = "NORMAL";
        }
        notifyPropertyChanged(BR.urgency);
    }

    public void goToSendKartable(TextView textView){
        OnEventListennerSend.title = title;
        OnEventListennerSend.receiverRole = receiverRole;
        OnEventListennerSend.receiverName = receiverName;
        OnEventListennerSend.urgency = urgency;
        OnEventListennerSend.confidentiality = confidentiality;
        OnEventListennerSend.from = from;
        OnEventListennerSend.to = to;
        Bundle bundle = new Bundle();
        bundle.putInt("currentPage",2);
        Navigation.findNavController(textView).navigate(R.id.action_sendSearchFragment_to_kartableFragment,bundle);
    }

    //getter and setter
    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }
    @Bindable
    public String getReceiverRole() {
        return receiverRole;
    }

    public void setReceiverRole(String receiverRole) {
        this.receiverRole = receiverRole;
        notifyPropertyChanged(BR.receiverRole);
    }
    @Bindable
    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
        notifyPropertyChanged(BR.receiverName);
    }
    @Bindable
    public String getConfidentiality() {
        return confidentiality;
    }

    public void setConfidentiality(String confidentiality) {
        this.confidentiality = confidentiality;
        notifyPropertyChanged(BR.confidentiality);
    }
    @Bindable
    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
        notifyPropertyChanged(BR.urgency);
    }
    @Bindable
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
        notifyPropertyChanged(BR.from);
    }
    @Bindable
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
        notifyPropertyChanged(BR.to);
    }
}
