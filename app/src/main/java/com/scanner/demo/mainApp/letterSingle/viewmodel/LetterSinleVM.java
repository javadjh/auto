package com.scanner.demo.mainApp.letterSingle.viewmodel;

import android.content.Context;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;

import com.scanner.demo.BR;
import com.scanner.demo.WebService.LetterService.letterService;
import com.scanner.demo.mainApp.letterSingle.model.LetterSingleRoot;
import com.scanner.demo.mainApp.letterSingle.model.TrackRoot;
import com.scanner.demo.mainApp.letterSingle.model.data;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class LetterSinleVM extends BaseObservable {
    //base variable
    private data data;
    private boolean status;
    private String message;
    //main variable
    private LetterSingleRoot letterSingleRoot;
    private String letterId;
    private String actionId;
    //context and mutable
    private Context context;
    private MutableLiveData<LetterSingleRoot> singleRootMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<TrackRoot> trackRootMutableLiveData = new MutableLiveData<>();

    //cons
    public LetterSinleVM(Context context, String actionId,String letterId) {
        this.context = context;
        this.actionId = actionId;
        this.letterId = letterId;
        getSinlgeData();
    }

    //logic
    private void getSinlgeData() {
        letterService letterService = new letterService(context);
        singleRootMutableLiveData = letterService.getSingleLetter(actionId);
        trackRootMutableLiveData = letterService.getTrack(letterId);
        notifyPropertyChanged(BR.singleRootMutableLiveData);
        notifyPropertyChanged(BR.trackRootMutableLiveData);
    }

    //setProfile
    @BindingAdapter("android:setPrifileSingleLetter")
    public static void setProfileImage(CircleImageView circleImageView,String url) {
        Picasso.get().load(url).into(circleImageView);
    }


    //getter and setter
    @Bindable
    public MutableLiveData<TrackRoot> getTrackRootMutableLiveData() {
        return trackRootMutableLiveData;
    }

    public void setTrackRootMutableLiveData(MutableLiveData<TrackRoot> trackRootMutableLiveData) {
        this.trackRootMutableLiveData = trackRootMutableLiveData;
        notifyPropertyChanged(BR.trackRootMutableLiveData);
    }

    @Bindable
    public com.scanner.demo.mainApp.letterSingle.model.data getData() {
        return data;
    }

    public void setData(com.scanner.demo.mainApp.letterSingle.model.data data) {
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
        notifyPropertyChanged(BR.message);
    }
    @Bindable
    public LetterSingleRoot getLetterSingleRoot() {
        return letterSingleRoot;
    }

    public void setLetterSingleRoot(LetterSingleRoot letterSingleRoot) {
        this.letterSingleRoot = letterSingleRoot;
        notifyPropertyChanged(BR.letterSingleRoot);
    }
    @Bindable
    public MutableLiveData<LetterSingleRoot> getSingleRootMutableLiveData() {
        return singleRootMutableLiveData;
    }
    public void setSingleRootMutableLiveData(MutableLiveData<LetterSingleRoot> singleRootMutableLiveData) {
        this.singleRootMutableLiveData = singleRootMutableLiveData;
        notifyPropertyChanged(BR.singleRootMutableLiveData);
    }
}
