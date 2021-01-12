package com.scanner.demo.mainApp.kartable.searchKartable.viewmodel;

import android.content.Context;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.navigation.Navigation;

import com.jaredrummler.materialspinner.MaterialSpinner;
import com.scanner.demo.BR;
import com.scanner.demo.CustomClass.dateSorting;
import com.scanner.demo.CustomClass.onClickEvent.onClickgetDate;
import com.scanner.demo.R;
import com.scanner.demo.mainApp.kartable.searchKartable.model.OnEventListtenerReceive;

import java.util.ArrayList;
import java.util.List;

public class ReceivedSearchVM extends BaseObservable {
    //searchValueVariable
    private String title;
    private String senderRole;
    private String senderName;
    private String confidentiality;
    private String urgency;
    private String from;
    private String to;
    private Boolean notObserved;
    private String sortBy;
    //otherVariable
    private Context context;

    //cons
    public ReceivedSearchVM(Context context) {
        this.context = context;
    }

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
    }

    public void getToDate(TextView textView){
        dateSorting dateSorting = new dateSorting(textView.getContext(), new onClickgetDate() {
            @Override
            public void getDate(String date) {
                to = date;
                textView.setText(date);
                notifyPropertyChanged(BR.to);
            }
        });
        dateSorting.toDate();
    }

    public void setConfidentailySpinner(MaterialSpinner materialSpinner,String hint){
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
        materialSpinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                confidentiality = listConfidentailyEnum.get(position);
                Toast.makeText(materialSpinner.getContext(), listConfidentailyEnum.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setObsearvRadio( RadioButton observedRB , RadioButton notObservedRB){
        if(observedRB.isChecked()){
            notObserved = false;
        }
        if(notObservedRB.isChecked()){
            notObserved = true;
        }
        notifyPropertyChanged(BR.notObserved);
    }

    public void setUrgentRadio(RadioButton urgentRB , RadioButton normalRB){
        if(urgentRB.isChecked()){
            urgency = "URGENT";
        }
        if(normalRB.isChecked()){
            urgency = "NORMAL";
        }
        notifyPropertyChanged(BR.urgency);
    }

    public void backToFragment(TextView button){
        OnEventListtenerReceive.title = title;
        OnEventListtenerReceive.senderRole = senderRole;
        OnEventListtenerReceive.senderName = senderName;
        OnEventListtenerReceive.urgency = urgency;
        OnEventListtenerReceive.confidentiality = confidentiality;
        OnEventListtenerReceive.from = from;
        OnEventListtenerReceive.to = to;
        OnEventListtenerReceive.notObserved = notObserved;
        Bundle bundle = new Bundle();
        bundle.putInt("currentPage",1);
        Navigation.findNavController(button).navigate(R.id.action_receivedSearchFragment_to_kartableFragment,bundle);
    }

    //getter and setter
    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(com.scanner.demo.BR.title);
    }
    @Bindable
    public String getSenderRole() {
        return senderRole;
    }

    public void setSenderRole(String senderRole) {
        this.senderRole = senderRole;
        notifyPropertyChanged(BR.senderRole);
    }
    @Bindable
    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
        notifyPropertyChanged(BR.senderName);
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
    @Bindable
    public Boolean getNotObserved() {
        return notObserved;
    }

    public void setNotObserved(Boolean notObserved) {
        this.notObserved = notObserved;
        notifyPropertyChanged(BR.notObserved);
    }
    @Bindable
    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
        notifyPropertyChanged(BR.sortBy);
    }
}
