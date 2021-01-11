package com.scanner.demo.mainApp.kartable.searchKartable.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scanner.demo.R;
import com.scanner.demo.databinding.FragmentSendSearchBinding;
import com.scanner.demo.mainApp.kartable.searchKartable.viewmodel.SendSearchVM;

public class SendSearchFragment extends Fragment {
    FragmentSendSearchBinding fragmentSendSearchBinding;
    SendSearchVM sendSearchVM;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentSendSearchBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_send_search,container,false);
        return fragmentSendSearchBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sendSearchVM = new SendSearchVM();
        fragmentSendSearchBinding.setSendSearchVM(sendSearchVM);
    }
}