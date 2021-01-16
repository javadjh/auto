package com.scanner.demo.WebService.FileService;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.scanner.demo.WebService.APIClient;

import java.io.File;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
import okhttp3.ResponseBody;

import static android.content.Context.DOWNLOAD_SERVICE;

public class FileService {
    private Context context;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private APIClient apiClient;

    public FileService(Context context) {
        this.context = context;
    }

    //downloadFile
    public void getFile(String id){
        apiClient = new APIClient();
        compositeDisposable.add(apiClient.GET_FILE(id)
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(new DisposableSingleObserver<ResponseBody>() {
            @Override
            public void onSuccess(@NonNull ResponseBody body) {

            }

            @Override
            public void onError(@NonNull Throwable e) {
                Toast.makeText(context, "error : " + e.toString(), Toast.LENGTH_SHORT).show();
            }
        }));
    }
}
