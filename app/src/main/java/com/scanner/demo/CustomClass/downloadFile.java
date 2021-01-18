package com.scanner.demo.CustomClass;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ProgressBar;

import com.scanner.demo.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;

import okhttp3.ResponseBody;

public class downloadFile {
    private static final String TAG = "donwloadFile";

    public static boolean writeResponseBodyToDisk(Context context, ResponseBody body,String fileName , String ext) {
        try {
            Dialog dialog = new Dialog(context);
            dialog.setContentView(R.layout.loading_dowenload);
            WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
            lp.copyFrom(Objects.requireNonNull(dialog.getWindow()).getAttributes());
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WindowManager.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            ProgressBar progressDownload = dialog.findViewById(R.id.progressDownload);
            progressDownload.setMax(100);
            progressDownload.setProgress(0);
            dialog.show();
            // todo change the file location/name according to your needs
            File futureStudioIconFile = new File(context.getExternalFilesDir(null) + File.separator + fileName + ext);
            Log.i(TAG,context.getExternalFilesDir(null) + File.separator + "Future Studio Icon.jpg");
            InputStream inputStream = null;
            OutputStream outputStream = null;
            try {
                byte[] fileReader = new byte[4096];
                long fileSize = body.contentLength();
                long fileSizeDownloaded = 0;
                inputStream = body.byteStream();
                outputStream = new FileOutputStream(futureStudioIconFile);
                //dialog.show();
                while (true) {
                    int read = inputStream.read(fileReader);
                    if (read == -1) {
                        break;
                    }
                    outputStream.write(fileReader, 0, read);
                    fileSizeDownloaded += read;
                    Log.d(TAG, "file download: " + fileSizeDownloaded + " of " + fileSize);
                    Log.d(TAG, "file downloadee: " + Integer.parseInt((fileSizeDownloaded*100)/fileSize+"") + "");
                    progressDownload.setProgress(Integer.parseInt((fileSizeDownloaded*100)/fileSize+""));
                }
                dialog.show();
                /*Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog.dismiss();
                    }
                },1000);*/

                outputStream.flush();
                return true;
            } catch (IOException e) {
                return false;
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            }
        } catch (IOException e) {
            return false;
        }
    }
}
