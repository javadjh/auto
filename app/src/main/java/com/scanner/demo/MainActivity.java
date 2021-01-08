package com.scanner.demo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.scanlibrary.ScanActivity;
import com.scanlibrary.ScanConstants;
import com.scanner.demo.CustomClass.LoadingDialog;
import com.scanner.demo.WebService.APIClient;
import com.scanner.demo.databinding.ActivityMainAppBinding;
import com.scanner.demo.mainApp.fileManager.view.FileManegerFragment;
import com.scanner.demo.mainApp.kartable.upsertLetter.view.UpsertLetterStepTwoFragment;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import ja.burhanrashid52.photoeditor.OnSaveBitmap;
import ja.burhanrashid52.photoeditor.PhotoEditor;
import ja.burhanrashid52.photoeditor.PhotoEditorView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 99;
    private Button scanButton;
    private Button cameraButton;
    private Button mediaButton;
    private PhotoEditorView scannedImageView;
    private Button addText;
    private EditText textContent;
    private ImageView drawInImage;
    private View uploadMenu;
    private LinearLayout addTextBlock;
    private boolean isDraw = true;
    private ImageView sendFileForUpload;
    private EditText fileNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        cameraButton = (Button) findViewById(R.id.cameraButton);
        cameraButton.setOnClickListener(new ScanButtonClickListener(ScanConstants.OPEN_CAMERA));
        mediaButton = (Button) findViewById(R.id.mediaButton);
        mediaButton.setOnClickListener(new ScanButtonClickListener(ScanConstants.OPEN_MEDIA));
        scannedImageView = findViewById(R.id.scannedImage);
        addText = findViewById(R.id.addText);
        textContent = findViewById(R.id.textContent);
        drawInImage = findViewById(R.id.drawInImage);
        uploadMenu = findViewById(R.id.uploadMenu);
        addTextBlock = findViewById(R.id.addTextBlock);
        sendFileForUpload = findViewById(R.id.sendFileForUpload);
        fileNameEditText = findViewById(R.id.fileNameEditText);
    }

    private class ScanButtonClickListener implements View.OnClickListener {

        private int preference;

        public ScanButtonClickListener(int preference) {
            this.preference = preference;
        }

        public ScanButtonClickListener() {
        }

        @Override
        public void onClick(View v) {
            startScan(preference);
        }
    }

    protected void startScan(int preference) {
        Intent intent = new Intent(this, ScanActivity.class);
        intent.putExtra(ScanConstants.OPEN_INTENT_PREFERENCE, preference);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            Uri uri = data.getExtras().getParcelable(ScanConstants.SCANNED_RESULT);
            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                getContentResolver().delete(uri, null, null);
                mediaButton.setVisibility(View.GONE);
                cameraButton.setVisibility(View.GONE);
                uploadMenu.setVisibility(View.VISIBLE);
                addTextBlock.setVisibility(View.VISIBLE);
                scannedImageView.getSource().setImageBitmap(RotateBitmap(bitmap,90));
                Typeface typeface = Typeface.createFromAsset(getAssets(),"vazir.ttf");

                PhotoEditor mPhotoEditor = new PhotoEditor.Builder(this, scannedImageView)
                        .setPinchTextScalable(true)
                        .setDefaultEmojiTypeface(typeface)
                        .setDefaultTextTypeface(typeface)
                        .build();
                addText.setOnClickListener(View ->{
                    mPhotoEditor.addText(textContent.getText().toString(),Color.BLACK);
                });
                drawInImage.setOnClickListener(View->{
                    if(!isDraw) {
                        drawInImage.setBackground(getResources().getDrawable(R.drawable.style_circle_red));
                        mPhotoEditor.setBrushDrawingMode(true);
                        mPhotoEditor.setBrushSize(8);
                        mPhotoEditor.setBrushColor(Color.BLACK);
                        isDraw = !isDraw;
                    }else{
                        drawInImage.setBackground(null);
                        mPhotoEditor.setBrushDrawingMode(false);
                        isDraw = !isDraw;
                    }
                });
                sendFileForUpload.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPhotoEditor.saveAsBitmap(new OnSaveBitmap() {
                            @Override
                            public void onBitmapReady(Bitmap saveBitmap) {
                                //save to gallery
                                MediaStore.Images.Media.insertImage(getContentResolver(), saveBitmap, "yourTitle" , "yourDescription");



                                File f = new File(getCacheDir(), "sadasca");
                                try {
                                    f.createNewFile();

//Convert bitmap to byte array
                                    Bitmap bitmap = saveBitmap;
                                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                                    bitmap.compress(Bitmap.CompressFormat.PNG, 0 /*ignored for PNG*/, bos);
                                    byte[] bitmapdata = bos.toByteArray();

//write the bytes in file
                                    FileOutputStream fos = new FileOutputStream(f);
                                    fos.write(bitmapdata);
                                    fos.flush();
                                    fos.close();
                                    // Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                                saveBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos); // bm is the bitmap object
                                byte[] b = baos.toByteArray();

                                SendFileForUpload(fileNameEditText.getText().toString() + " .jpg",b);



                            }

                            @Override
                            public void onFailure(Exception e) {

                            }
                        });
                    }
                });

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void SendFileForUpload(String type ,byte[] bytes) {
        LoadingDialog loadingDialog = new LoadingDialog();
        loadingDialog.loading(MainActivity.this);
        APIClient apiClient = new APIClient();
        RequestBody requestFile = RequestBody.create(MediaType.parse("*/*"),bytes);

        MultipartBody.Part file  = MultipartBody.Part.createFormData("file", type , requestFile);

        Call<String> call = apiClient
                .UPLOAD_FILE
                        (file);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                loadingDialog.dismisDialog();
                finish();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                loadingDialog.dismisDialog();
                finish();
            }
        });

    }

    private Bitmap convertByteArrayToBitmap(byte[] data) {
        return BitmapFactory.decodeByteArray(data, 0, data.length);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public static Bitmap RotateBitmap(Bitmap source, float angle) {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);
    }
}
