package com.scanner.demo.mainApp.kartable.upsertLetter.viewmodel;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

import androidx.databinding.BaseObservable;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.Navigation;

import com.jaredrummler.materialspinner.MaterialSpinner;
import com.scanner.demo.R;
import com.scanner.demo.WebService.LetterService.letterService;
import com.scanner.demo.mainApp.kartable.upsertLetter.model.UpsertLetterRoot;
import com.scanner.demo.mainApp.kartable.upsertLetter.model.UpsertResponse;

public class UpsertLetterStepTwoVM extends BaseObservable {
    private Context context;
    private MutableLiveData<UpsertResponse> upsertResponseMutableLiveData = new MutableLiveData<>();

    public UpsertLetterStepTwoVM(Context context) {
        this.context = context;
    }

    //logic
    @BindingAdapter("android:fontSpinnerTypeface")
    public static void setFontForSpinner(MaterialSpinner materialSpinner , String hint){
        Typeface typeface = Typeface.createFromAsset(materialSpinner.getContext().getAssets(), "vazir.ttf");
        materialSpinner.setTypeface(typeface);
        materialSpinner.setHint(hint);
    }

    //Navigate to AddFile Activity
    public void addFile(TextView textView){
        textView.setOnClickListener(View->{
            Navigation.findNavController(textView).navigate(R.id.action_upsertLetterStepTwoFragment_to_mainActivity);
        });
    }

    //Connect To Upsert Letter Service
    public MutableLiveData<UpsertResponse> upsertLetter(UpsertLetterRoot upsertLetterRoot){
        letterService letterService = new letterService(context);
        upsertResponseMutableLiveData = letterService.upsertLetter(upsertLetterRoot);
        return upsertResponseMutableLiveData;
    }
}
