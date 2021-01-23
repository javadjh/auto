package com.scanner.demo.WebService;

import com.scanner.demo.CustomClass.Token;
import com.scanner.demo.mainApp.fileManager.model.FileManagerModelResponseRoot;
import com.scanner.demo.mainApp.homePage.model.ReceiveLetterRoot;
import com.scanner.demo.loginPage.model.LoginModelBody;
import com.scanner.demo.loginPage.model.LoginModelResponseRoot;
import com.scanner.demo.mainApp.kartable.model.DraftResponseRoot;
import com.scanner.demo.mainApp.kartable.upsertLetter.model.UpsertLetterRoot;
import com.scanner.demo.mainApp.kartable.upsertLetter.model.UpsertResponse;
import com.scanner.demo.mainApp.kartable.upsertLetter.model.UsersResponseRoot;
import com.scanner.demo.mainApp.letterSingle.action.model.ActionBody;
import com.scanner.demo.mainApp.letterSingle.model.LetterSingleRoot;
import com.scanner.demo.mainApp.letterSingle.model.TrackRoot;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Single;
import okhttp3.Interceptor;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient  {
    public static final String BASE_URL = "http://37.32.46.12:4000";
    Retrofit retrofit = null;
    APIInterface apiInterface;
    public APIClient(){

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest  = chain.request().newBuilder()

                        .addHeader("Authorization", " Bearer " + Token.token)
                        .build();
                return chain.proceed(newRequest);
            }
        })
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiInterface = retrofit.create(APIInterface.class);

    }
    public Single<LoginModelResponseRoot> LOGIN(LoginModelBody loginModelBody){
        return apiInterface.login(loginModelBody);
    }
    public Single<ReceiveLetterRoot> RECEIVE_LETTER(String title,String senderName,String urgency,String from,String to,Boolean notObserved ,String confidentiality){
        return apiInterface.getReceive(title, senderName, urgency, from, to, notObserved, 1, 100,confidentiality);
    }
    public Single<LetterSingleRoot> LETTER_SINGLE(String id){
        return apiInterface.getLetterSingle(id);
    }
    public Single<ReceiveLetterRoot> SEND_LETTER(String title, String receiverRole, String receiverName, String confidentiality, String urgency,String from,String to){
        return apiInterface.getSend(title, receiverRole, receiverName, confidentiality, urgency,from,to,1,100);
    }
    public Single<DraftResponseRoot> DRAFT_LETTER(){
        return apiInterface.getDraft(1,50);
    }
    public Single<UsersResponseRoot> GET_USERS(){
        return apiInterface.getUsers();
    }
    public Single<FileManagerModelResponseRoot> GET_FILES(String From,String To,String FileName,int PageNumber,int PageSize){
        return apiInterface.getFiles(From,To,FileName,PageNumber,PageSize);
    }
    public Call<String> UPLOAD_FILE(MultipartBody.Part bodyFile){
        return apiInterface.sendFile(bodyFile);
    }
    public Single<ResponseBody> GET_FILE(String id){
        return apiInterface.getFile(id);
    }
    public Single<TrackRoot> GET_TRACK(String id){
        return apiInterface.getTrackLetter(id);
    }
    public Single<UpsertResponse> UPSERT_LETTER(UpsertLetterRoot upsertLetterRoot){
        return apiInterface.upsertLetter(upsertLetterRoot);
    }
    public Single<UpsertResponse> ACTION(ActionBody actionBody){
        return apiInterface.actionLetter(actionBody);
    }

}
