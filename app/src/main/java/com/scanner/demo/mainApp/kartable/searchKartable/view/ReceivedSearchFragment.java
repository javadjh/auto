package com.scanner.demo.mainApp.kartable.searchKartable.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.scanner.demo.CustomClass.dateSorting;
import com.scanner.demo.R;
import com.scanner.demo.databinding.FragmentReceivedSearchBinding;
import com.scanner.demo.mainApp.kartable.searchKartable.viewmodel.ReceivedSearchVM;


public class ReceivedSearchFragment extends Fragment {
    FragmentReceivedSearchBinding fragmentReceivedSearchBinding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentReceivedSearchBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_received_search,container,false);
        return fragmentReceivedSearchBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ReceivedSearchVM receivedSearchVM = new ReceivedSearchVM(getContext());
        fragmentReceivedSearchBinding.setReceivedSearchVM(receivedSearchVM);
    }
}