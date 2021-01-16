package com.scanner.demo.WebService.LetterService;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.scanner.demo.CustomClass.AlertDialog;
import com.scanner.demo.mainApp.homePage.model.ReceiveLetterRoot;
import com.scanner.demo.WebService.APIClient;
import com.scanner.demo.mainApp.kartable.model.DraftResponseRoot;
import com.scanner.demo.mainApp.kartable.upsertLetter.model.UpsertLetterRoot;
import com.scanner.demo.mainApp.kartable.upsertLetter.model.UpsertResponse;
import com.scanner.demo.mainApp.letterSingle.model.LetterSingleRoot;
import com.scanner.demo.mainApp.letterSingle.model.TrackRoot;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class letterService extends ViewModel {
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    //getReceive
    private MutableLiveData<ReceiveLetterRoot> receiveLetterRootMutableLiveData = new MutableLiveData<>();
    //getSingle
    private MutableLiveData<LetterSingleRoot> singleRootMutableLiveData  = new MutableLiveData<>();
    //getSend
    private MutableLiveData<ReceiveLetterRoot> sendMutableLiveData  = new MutableLiveData<>();
    //getDraft
    private MutableLiveData<DraftResponseRoot> draftResponseRootMutableLiveData = new MutableLiveData<>();
    //getTrack
    private MutableLiveData<TrackRoot> trackRootMutableLiveData = new MutableLiveData<>();
    //upsertLetter
    private MutableLiveData<UpsertResponse> upsertResponseMutableLiveData = new MutableLiveData<>();
    APIClient apiClient;
    Context context;

    public letterService(Context context) {
        this.context = context;
    }

    //getReceivedLetter Service
    public MutableLiveData<ReceiveLetterRoot> getReceivedLetter(String title,String senderName,String urgency,String from,String to,Boolean notObserved,String confidentiality){
        apiClient = new APIClient();
        compositeDisposable.add(apiClient.RECEIVE_LETTER(title, senderName, urgency, from, to, notObserved,confidentiality)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<ReceiveLetterRoot>() {
                    @Override
                    public void onSuccess(@NonNull ReceiveLetterRoot receiveLetterRoot) {
                        if (receiveLetterRootMutableLiveData.getValue() == null) {
                            receiveLetterRootMutableLiveData.postValue(receiveLetterRoot);
                            Log.i("rrrr", receiveLetterRoot.getData().getList().size() + "");
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        AlertDialog.showAlertDialog(context,"خطا در دریافت اطلاعات","خطا در دریافت اطلاعات از سرور رخ داده است لطفا اتصالات خود را بررسی نمایید");
                    }
                }));
        return receiveLetterRootMutableLiveData;
    }

    //getSingleLetter Service
    public MutableLiveData<LetterSingleRoot> getSingleLetter(String id){
        apiClient = new APIClient();
        compositeDisposable.add(apiClient.LETTER_SINGLE(id)
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(new DisposableSingleObserver<LetterSingleRoot>() {
            @Override
            public void onSuccess(@NonNull LetterSingleRoot letterSingleRoot) {
                if (singleRootMutableLiveData.getValue()==null){
                    singleRootMutableLiveData.setValue(letterSingleRoot);
                    Log.i("rrrr",letterSingleRoot.getData().getActionId());
                }
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.i("rrrrr",e.toString());
            }
        }));
        return singleRootMutableLiveData;
    }

    //getSendLetter Service
    public MutableLiveData<ReceiveLetterRoot> getSendLetter(String title, String receiverRole, String receiverName, String confidentiality, String urgency,String from,String to){
        apiClient = new APIClient();
        compositeDisposable.add(apiClient.SEND_LETTER(title, receiverRole, receiverName, confidentiality, urgency,from,to)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<ReceiveLetterRoot>() {
                    @Override
                    public void onSuccess(@NonNull ReceiveLetterRoot receiveLetterRoot) {
                        if (sendMutableLiveData.getValue() == null) {
                            sendMutableLiveData.postValue(receiveLetterRoot);
                            Log.i("rrrr", receiveLetterRoot.getData().getList().size() + "");
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        AlertDialog.showAlertDialog(context,"خطا در دریافت اطلاعات","خطا در دریافت اطلاعات از سرور رخ داده است لطفا اتصالات خود را بررسی نمایید");
                    }
                }));
        return sendMutableLiveData;
    }

    //getDraftLetter
    public MutableLiveData<DraftResponseRoot> getDraftLetter(){
        if(draftResponseRootMutableLiveData.getValue()==null) {
            apiClient = new APIClient();
            compositeDisposable.add(apiClient.DRAFT_LETTER()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<DraftResponseRoot>() {
                    @Override
                    public void onSuccess(@NonNull DraftResponseRoot draftResponseRoot) {
                        draftResponseRootMutableLiveData.setValue(draftResponseRoot);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        AlertDialog.showAlertDialog(context, "خطا در دریافت اطلاعات", "خطا در دریافت اطلاعات از سرور رخ داده است لطفا اتصالات خود را بررسی نمایید");
                    }
                }));
        }
        return draftResponseRootMutableLiveData;
    }

    //getLetterTrack
    public MutableLiveData<TrackRoot> getTrack(String id){
        apiClient = new APIClient();
        compositeDisposable.add(apiClient.GET_TRACK(id)
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(new DisposableSingleObserver<TrackRoot>() {
            @Override
            public void onSuccess(@NonNull TrackRoot trackRoot) {
                trackRootMutableLiveData.setValue(trackRoot);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.i("error",e.toString());
            }
        }));
        return trackRootMutableLiveData;
    }

    //upsertLetter
    public MutableLiveData<UpsertResponse> upsertLetter(UpsertLetterRoot upsertLetterRoot){
        apiClient = new APIClient();
        compositeDisposable.add(apiClient.UPSERT_LETTER(upsertLetterRoot)
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(new DisposableSingleObserver<UpsertResponse>() {
            @Override
            public void onSuccess(@NonNull UpsertResponse upsertResponse) {
                upsertResponseMutableLiveData.setValue(upsertResponse);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Toast.makeText(context, "e : " + e.toString(),  Toast.LENGTH_SHORT).show();
            }
        }));
        return upsertResponseMutableLiveData;
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }
}
