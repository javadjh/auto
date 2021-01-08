package com.scanner.demo.mainApp.archive.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scanner.demo.R;
import com.scanner.demo.databinding.FragmentArchiveBinding;
import com.scanner.demo.mainApp.homePage.view.HomePageFragmentDirections;

public class ArchiveFragment extends Fragment {
    FragmentArchiveBinding fragmentArchiveBinding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentArchiveBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_archive,container,false);
        return fragmentArchiveBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().getFragmentManager().popBackStack();

        fragmentArchiveBinding.fileManagerIcon.setOnClickListener(View->{
            NavDirections navDirections = ArchiveFragmentDirections.actionArchiveFragmentToFileManegerFragment();
            Navigation.findNavController(fragmentArchiveBinding.fileManagerIcon).navigate(navDirections);
        });
        fragmentArchiveBinding.kartableIcon.setOnClickListener(View->{
            NavDirections navDirections = ArchiveFragmentDirections.actionArchiveFragmentToKartableFragment();
            Navigation.findNavController(fragmentArchiveBinding.kartableIcon).navigate(navDirections);
        });
        fragmentArchiveBinding.homePageIcon.setOnClickListener(View->{
            NavDirections navDirections = ArchiveFragmentDirections.actionArchiveFragmentToHomePageFragment();
            Navigation.findNavController(fragmentArchiveBinding.kartableIcon).navigate(navDirections);
        });
    }
}