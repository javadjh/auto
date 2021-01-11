package com.scanner.demo.mainApp.showFile.view;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scanner.demo.R;
import com.scanner.demo.databinding.FragmentShowFileBinding;

public class ShowFileFragment extends Fragment {
    FragmentShowFileBinding fragmentShowFileBinding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentShowFileBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_show_file,container,false);
        return fragmentShowFileBinding.getRoot();
    }
}