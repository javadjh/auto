package com.scanner.demo.mainApp.kartable.upsertLetter.viewmodel;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.navigation.Navigation;

import com.chinalwb.are.AREditText;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.scanner.demo.BR;
import com.scanner.demo.R;

import java.util.ArrayList;
import java.util.List;

public class UpsertLetterStepOneVM extends BaseObservable {
    private Context context;
    private String confidently;
    private String urgently;

    public UpsertLetterStepOneVM(Context context) {
        this.context = context;
    }

    public void setSpinnerHintConfidentely(MaterialSpinner materialSpinner, String hint){
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
        materialSpinner.setOnItemSelectedListener((view, position, id, item) -> {
            confidently = listConfidentailyEnum.get(position);
            notifyPropertyChanged(BR.confidently);
        });
    }

    public void setSpinnerHintUrgent(MaterialSpinner materialSpinner, String hint){
        List<String> listUrgentEnum = new ArrayList<>();
        listUrgentEnum.add("NORMAL");
        listUrgentEnum.add("URGENT");
        List<String> listUrgent = new ArrayList<>();
        listUrgent.add("عادی");
        listUrgent.add("فوری");
        materialSpinner.setHint(hint);
        materialSpinner.setItems(listUrgent);
        materialSpinner.setOnItemSelectedListener((view, position, id, item) -> {
            urgently = listUrgentEnum.get(position);
            notifyPropertyChanged(BR.urgently);
        });
    }

    public void sendToStepTwo(Button button, EditText letterTitle, AREditText arEditText){
        Bundle bundle = new Bundle();
        bundle.putString("letterTitle",letterTitle.getText().toString());
        bundle.putString("descriptionLetter",arEditText.getHtml());
        bundle.putString("confidently",confidently);
        bundle.putString("urgently",urgently);
        Navigation.findNavController(button).navigate(R.id.action_upsertLetterFragment_to_upsertLetterStepTwoFragment,bundle);
    }

    //getter and setter
    @Bindable
    public String getConfidently() {
        return confidently;
    }

    public void setConfidently(String confidently) {
        this.confidently = confidently;
        notifyPropertyChanged(BR.confidently);
    }
    @Bindable
    public String getUrgently() {
        return urgently;
    }

    public void setUrgently(String urgently) {
        this.urgently = urgently;
        notifyPropertyChanged(BR.urgently);
    }
}
