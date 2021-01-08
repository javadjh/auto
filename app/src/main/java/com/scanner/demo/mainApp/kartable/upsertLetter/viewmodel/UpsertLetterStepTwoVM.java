package com.scanner.demo.mainApp.kartable.upsertLetter.viewmodel;

import android.content.Context;
import android.graphics.Typeface;

import androidx.databinding.BaseObservable;
import androidx.databinding.BindingAdapter;

import com.jaredrummler.materialspinner.MaterialSpinner;

public class UpsertLetterStepTwoVM extends BaseObservable {
    private Context context;

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
}
