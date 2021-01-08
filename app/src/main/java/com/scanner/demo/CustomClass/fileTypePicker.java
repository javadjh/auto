package com.scanner.demo.CustomClass;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;

import com.scanner.demo.R;

public class fileTypePicker {
    @SuppressLint("UseCompatLoadingForDrawables")
    public static int fileTypePickerMethod(Context context , String type){
        int drawable = 0;
        switch (type.toLowerCase()){
            case ".ai":
                drawable = R.drawable.ic_ai;
                break;
            case ".app":
                drawable = R.drawable.ic_app;
                break;
            case ".asp":
                drawable = R.drawable.ic_asp;
                break;
            case ".bat":
                drawable = R.drawable.ic_bat;
                break;
            case ".cs":
                drawable = R.drawable.ic_ccharp;
                break;
            case ".ccp":
                drawable = R.drawable.ic_cplusplus;
                break;
            case ".css":
                drawable = R.drawable.ic_css;
                break;
            case ".csv":
                drawable = R.drawable.ic_csv;
                break;
            case ".dat":
                drawable = R.drawable.ic_dat;
                break;
            case ".dll":
                drawable = R.drawable.ic_dll;
                break;
            case ".doc":
                drawable = R.drawable.ic_doc;
                break;
            case ".docx":
                drawable = R.drawable.ic_docx;
                break;
            case ".dwg":
                drawable = R.drawable.ic_dwg;
                break;
            case ".eml":
                drawable = R.drawable.ic_eml;
                break;
            case ".eps":
                drawable = R.drawable.ic_eps;
                break;
            case ".esp":
                drawable = R.drawable.ic_exe;
                break;
            case ".flv":
                drawable = R.drawable.ic_flv;
                break;
            case ".gif":
                drawable = R.drawable.ic_gif;
                break;
            case ".html":
                drawable = R.drawable.ic_html;
                break;
            case ".ics":
                drawable = R.drawable.ic_ics;
                break;
            case ".iso":
                drawable = R.drawable.ic_iso;
                break;
            case ".jar":
                drawable = R.drawable.ic_jar;
                break;
            case ".java":
                drawable = R.drawable.ic_jar;
                break;
            case ".jpeg":
                drawable = R.drawable.ic_jpeg;
                break;
            case ".jpg":
                drawable = R.drawable.ic_jpg;
                break;
            case ".js":
                drawable = R.drawable.ic_js;
                break;
            case ".log":
                drawable = R.drawable.ic_log;
                break;
            case ".mdb":
                drawable = R.drawable.ic_mdb;
                break;
            case ".mov":
                drawable = R.drawable.ic_mov;
                break;
            case ".mp3":
                drawable = R.drawable.ic_mp3;
                break;
            case ".mp4":
                drawable = R.drawable.ic_mp4;
                break;
            case ".obj":
                drawable = R.drawable.ic_obj;
                break;
            case ".otf":
                drawable = R.drawable.ic_otf;
                break;
            case ".pdf":
                drawable = R.drawable.ic_pdf;
                break;
            case ".php":
                drawable = R.drawable.ic_php;
                break;
            case ".png":
                drawable = R.drawable.ic_png;
                break;
            case ".ppt":
                drawable = R.drawable.ic_ppt;
                break;
            case ".psd":
                drawable = R.drawable.ic_psd;
                break;
            case ".pub":
                drawable = R.drawable.ic_pub;
                break;
            case ".rar":
                drawable = R.drawable.ic_rar;
                break;
            case ".sql":
                drawable = R.drawable.ic_sql;
                break;
            case ".srt":
                drawable = R.drawable.ic_sqr;
                break;
            case ".svg":
                drawable = R.drawable.ic_svg;
                break;
            case ".3ds":
                drawable = R.drawable.ic_threeds;
                break;
            case ".ttf":
                drawable = R.drawable.ic_ttf;
                break;
            case ".wav":
                drawable = R.drawable.ic_wav;
                break;
            case ".xls":
                drawable = R.drawable.ic_xls;
                break;
            case ".xlsx":
                drawable = R.drawable.ic_xlsx;
                break;
            case ".xml":
                drawable = R.drawable.ic_xml;
                break;
            case ".zip":
                drawable = R.drawable.ic_zip;
                break;
        }
        return drawable;
    }
}
