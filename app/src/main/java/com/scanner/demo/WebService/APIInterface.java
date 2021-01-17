package com.scanner.demo.WebService;

import com.scanner.demo.mainApp.fileManager.model.FileManagerModelResponseRoot;
import com.scanner.demo.mainApp.homePage.model.ReceiveLetterRoot;
import com.scanner.demo.loginPage.model.LoginModelBody;
import com.scanner.demo.loginPage.model.LoginModelResponseRoot;
import com.scanner.demo.mainApp.kartable.model.DraftResponseRoot;
import com.scanner.demo.mainApp.kartable.upsertLetter.model.UpsertLetterRoot;
import com.scanner.demo.mainApp.kartable.upsertLetter.model.UpsertResponse;
import com.scanner.demo.mainApp.kartable.upsertLetter.model.UsersResponseRoot;
import com.scanner.demo.mainApp.letterSingle.model.LetterSingleRoot;
import com.scanner.demo.mainApp.letterSingle.model.TrackRoot;
import com.scanner.demo.mainApp.letterSingle.action.model.ActionBody;

import io.reactivex.rxjava3.core.Single;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIInterface {

    @POST("/api/v2/account/login")
    Single<LoginModelResponseRoot> login(@Body LoginModelBody loginModelBody);

    @GET("/api/v2/letter/received")
    Single<ReceiveLetterRoot> getReceive(@Query("Title") String Title, @Query("SenderName") String SenderName, @Query("Urgency") String Urgency, @Query("From") String From, @Query("To") String To, @Query("NotObserved") Boolean NotObserved, @Query("PageNumber") Integer PageNumber, @Query("PageSize") Integer PageSize,@Query("Confidentiality") String Confidentiality);

    @GET("/api/v2/letter/{id}")
    Single<LetterSingleRoot> getLetterSingle(@Path("id") String id);

    @GET("/api/v2/letter/sent")
    Single<ReceiveLetterRoot> getSend(@Query("Title") String Title, @Query("ReceiverRole") String ReceiverRole, @Query("ReceiverName") String ReceiverName, @Query("Confidentiality") String Confidentiality, @Query("Urgency") String Urgency, @Query("From") String From, @Query("To") String To,@Query("PageNumber") int PageNumber,@Query("PageSize") int PageSize );

    @GET("/api/v2/letter/draft")
    Single<DraftResponseRoot> getDraft(@Query("PageNumber") int PageNumber, @Query("PageSize") int PageSize);

    @GET("/api/v2/account/users/relatives")
    Single<UsersResponseRoot> getUsers();

    @GET("/api/v2/account/files")
    Single<FileManagerModelResponseRoot> getFiles(@Query("From") String From, @Query("To") String To, @Query("FileName") String FileName,@Query("PageNumber") int PageNumber, @Query("PageSize") int PageSize);

    @Multipart
    @POST("/api/v2/file/upload")
    Call<String> sendFile(@Part MultipartBody.Part bodyFile);

    @GET("/api/v2/file/download/{id}")
    Single<ResponseBody> getFile(@Path("id") String id);

    @GET("/api/v2/letter/track/{id}")
    Single<TrackRoot> getTrackLetter(@Path("id") String id);

    @POST("/api/v2/letter/upsert")
    Single<UpsertResponse> upsertLetter(@Body UpsertLetterRoot upsertLetterRoot);

    @POST("/api/v2/letter/action")
    Single<UpsertResponse> actionLetter(@Body ActionBody actionBody);
}