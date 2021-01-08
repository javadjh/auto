package com.scanner.demo.mainApp.kartable.view;

import android.app.Activity;
import android.app.FragmentManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.scanner.demo.R;
import com.scanner.demo.databinding.FragmentKartableBinding;
import com.scanner.demo.mainApp.homePage.view.HomePageFragmentDirections;
import com.scanner.demo.mainApp.kartable.adapter.SliderAdapter;

import java.util.Objects;

public class KartableFragment extends Fragment {
    FragmentKartableBinding fragmentKartableBinding;
    private FragmentActivity myContext;
    private int[] tabIcons = {
            R.drawable.ic_recieve,
            R.drawable.ic_send,
            R.drawable.ic_draft
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentKartableBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_kartable,container,false);
        tabBarLayoutInit();
        return fragmentKartableBinding.getRoot();
    }

    private void tabBarLayoutInit() {
        fragmentKartableBinding.setKartableFragment(this);
        fragmentKartableBinding.kartableViewPager.setAdapter(new SliderAdapter(requireActivity().getSupportFragmentManager()));
        fragmentKartableBinding.tabBarActionBar.setupWithViewPager(fragmentKartableBinding.kartableViewPager);
        fragmentKartableBinding.kartableViewPager.setCurrentItem(2);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().getFragmentManager().popBackStack();
        menuSwitcher();
        setTabLayoutUiSetting();
        fragmentKartableBinding.addLetter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections navDirections = KartableFragmentDirections.actionKartableFragmentToUpsertLetterFragment();
                Navigation.findNavController(fragmentKartableBinding.kartableIcon).navigate(navDirections);
            }
        });
    }

    private void menuSwitcher() {
        fragmentKartableBinding.archiveIcon.setOnClickListener(View ->{
            NavDirections navDirections = KartableFragmentDirections.actionKartableFragmentToArchiveFragment();
            Navigation.findNavController(fragmentKartableBinding.archiveIcon).navigate(navDirections);
        });
        fragmentKartableBinding.fileManagerIcon.setOnClickListener(View->{
            NavDirections navDirections = KartableFragmentDirections.actionKartableFragmentToFileManegerFragment();
            Navigation.findNavController(fragmentKartableBinding.fileManagerIcon).navigate(navDirections);
        });
        fragmentKartableBinding.homePageIcon.setOnClickListener(View->{
            NavDirections navDirections = KartableFragmentDirections.actionKartableFragmentToHomePageFragment();
            Navigation.findNavController(fragmentKartableBinding.kartableIcon).navigate(navDirections);
        });
    }

    private void setTabLayoutUiSetting() {
        fragmentKartableBinding.tabBarActionBar.setBackgroundColor(getActivity().getResources().getColor(R.color.black));
        fragmentKartableBinding.tabBarActionBar.setSelectedTabIndicatorColor(getActivity().getResources().getColor(R.color.purple));
        for (int i = 0; i < fragmentKartableBinding.tabBarActionBar.getTabCount(); i++) {
            TextView tv = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.textviewtablayout,null);
            Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(),"vazir.ttf");
            tv.setTypeface(typeface);
            tv.setCompoundDrawablesWithIntrinsicBounds(0,tabIcons[i],0,0);
            fragmentKartableBinding.tabBarActionBar.getTabAt(i).setCustomView(tv);
        }
        setupTabIcons();
    }

    private void setupTabIcons() {
        fragmentKartableBinding.tabBarActionBar.getTabAt(0).setIcon(tabIcons[0]);
        fragmentKartableBinding.tabBarActionBar.getTabAt(1).setIcon(tabIcons[1]);
        fragmentKartableBinding.tabBarActionBar.getTabAt(2).setIcon(tabIcons[2]);
    }

}