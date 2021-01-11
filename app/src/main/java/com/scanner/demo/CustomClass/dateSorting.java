package com.scanner.demo.CustomClass;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.TextView;

import com.scanner.demo.CustomClass.onClickEvent.onClickgetDate;

import ir.hamsaa.persiandatepicker.Listener;
import ir.hamsaa.persiandatepicker.PersianDatePickerDialog;
import ir.hamsaa.persiandatepicker.util.PersianCalendar;

public class dateSorting {
    private String fromDate;
    private String toDate;
    private Context context;
    private com.scanner.demo.CustomClass.onClickEvent.onClickgetDate onClickgetDate;

    DateConverter converter1 = new DateConverter();
    int years = 0;
    int month = 0;
    int day = 0;

    DateConverter converter2 = new DateConverter();
    int years2 = 0;
    int month2 = 0;
    int day2 = 0;


    public dateSorting(Context context, com.scanner.demo.CustomClass.onClickEvent.onClickgetDate onClickgetDate) {
        this.context = context;
        this.onClickgetDate = onClickgetDate;
    }

    public void fromDate(){
        Typeface typeface = Typeface.createFromAsset(context.getAssets(),"vazir.ttf");
        PersianCalendar initDate = new PersianCalendar();
        initDate.setPersianDate(PersianDatePickerDialog.THIS_YEAR, 1, 1);
        PersianDatePickerDialog picker = new PersianDatePickerDialog(context)
                .setPositiveButtonString("انتخاب همین تاریخ")
                .setNegativeButton("انصراف")
                .setTodayButton("بیا به تاریخ امروز")
                .setTodayButtonVisible(true)
                .setMinYear(1390)
                .setTypeFace(typeface)
                .setMaxYear(PersianDatePickerDialog.THIS_YEAR)
                .setInitDate(initDate)
                .setActionTextColor(Color.RED)
                .setTitleType(PersianDatePickerDialog.WEEKDAY_DAY_MONTH_YEAR)
                .setShowInBottomSheet(true)
                .setListener(new Listener() {
                    @Override
                    public void onDateSelected(PersianCalendar persianCalendar) {
                        years = persianCalendar.getPersianYear();
                        month = persianCalendar.getPersianMonth();
                        day = persianCalendar.getPersianDay();
                        converter1.persianToGregorian(years,month,day);
                        fromDate = converter1.toString();
                        onClickgetDate.getDate(fromDate);
                    }

                    @Override
                    public void onDismissed() {

                    }
                });
        picker.setInitDate(initDate);
        picker.show();
    }
    public String toDate(){
        Typeface typeface = Typeface.createFromAsset(context.getAssets(),"vazir.ttf");
        PersianCalendar initDate2 = new PersianCalendar();
        initDate2.setPersianDate(PersianDatePickerDialog.THIS_YEAR, 1, 1);
        PersianCalendar initDate = new PersianCalendar();
        initDate2.setPersianDate(1399, 1, 1);
        PersianDatePickerDialog picker2 = new PersianDatePickerDialog(context)
                .setPositiveButtonString("انتخاب همین تاریخ")
                .setNegativeButton("انصراف")
                .setTodayButton("بیا به تاریخ امروز")
                .setTodayButtonVisible(true)
                .setMinYear(1390)
                .setTypeFace(typeface)
                .setMaxYear(PersianDatePickerDialog.THIS_YEAR)
                .setInitDate(initDate)
                .setActionTextColor(Color.RED)
                .setTitleType(PersianDatePickerDialog.WEEKDAY_DAY_MONTH_YEAR)
                .setShowInBottomSheet(true)
                .setListener(new Listener() {
                    @Override
                    public void onDateSelected(PersianCalendar persianCalendar) {
                        years2 = persianCalendar.getPersianYear();
                        month2 = persianCalendar.getPersianMonth();
                        day2 = persianCalendar.getPersianDay();
                        converter2.persianToGregorian(years2,month2,day2);
                        toDate = converter2.toString();
                        onClickgetDate.getDate(toDate);
                    }

                    @Override
                    public void onDismissed() {

                    }
                });
        picker2.setInitDate(initDate);
        picker2.show();
        return toDate;
    }
}
