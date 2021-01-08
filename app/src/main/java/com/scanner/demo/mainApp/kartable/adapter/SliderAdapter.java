package com.scanner.demo.mainApp.kartable.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import com.scanner.demo.mainApp.archive.view.ArchiveFragment;
import com.scanner.demo.mainApp.fileManager.view.FileManegerFragment;
import com.scanner.demo.mainApp.homePage.view.HomePageFragment;
import com.scanner.demo.mainApp.kartable.view.DraftKartableFragment;
import com.scanner.demo.mainApp.kartable.view.KartableFragment;
import com.scanner.demo.mainApp.kartable.view.ReceiveKartableFragment;
import com.scanner.demo.mainApp.kartable.view.SendKartableFragment;

public class SliderAdapter extends FragmentStatePagerAdapter {
    public SliderAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 1:
                return new ReceiveKartableFragment();
            case 2:
                return new SendKartableFragment();
            case 0:
                return new DraftKartableFragment();
        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 1:
                return "دریافتی";
            case 2:
                return "ارسالی";
            case 0:
                return "پیشنویس";
        }

        return super.getPageTitle(position);
    }


    @Override
    public int getCount() {
        return 3;
    }
}
