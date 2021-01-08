package com.scanner.demo.mainApp.kartable.upsertLetter.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.scanner.demo.R;
import com.scanner.demo.databinding.FragmentChoiseFileBootomSheetBinding;
import com.scanner.demo.mainApp.fileManager.model.FileManagerModelResponseRoot;
import com.scanner.demo.mainApp.kartable.upsertLetter.adapter.ChoiseFileCustomAdapter;
import com.scanner.demo.mainApp.kartable.upsertLetter.viewmodel.ChoiseFileBottomSheetVM;

public class ChoiseFileBootomSheet extends BottomSheetDialogFragment {
    FragmentChoiseFileBootomSheetBinding fragmentChoiseFileBootomSheetBinding;
    ChoiseFileBottomSheetVM choiseFileBottomSheetVM;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentChoiseFileBootomSheetBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_choise_file_bootom_sheet,container,false);
        return fragmentChoiseFileBootomSheetBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getFiles(null);
        fragmentChoiseFileBootomSheetBinding.searchFile.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                getFiles(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private void getFiles(String fileName) {
        choiseFileBottomSheetVM = new ChoiseFileBottomSheetVM(getContext(),fileName);
        MutableLiveData<FileManagerModelResponseRoot> fileManagerModelResponseRootMutableLiveData = choiseFileBottomSheetVM.getFileManagerModelResponseRootMutableLiveData();
        fileManagerModelResponseRootMutableLiveData.observe(getActivity(), fileManagerModelResponseRoot -> {
            choiseFileBottomSheetVM.setData(fileManagerModelResponseRoot.getData());
            fragmentChoiseFileBootomSheetBinding.recyChoiseFile.setAdapter(
                    new ChoiseFileCustomAdapter(getContext(),choiseFileBottomSheetVM.getData().getList()));
            fragmentChoiseFileBootomSheetBinding.setChoiseFileBottomSheetVM(choiseFileBottomSheetVM);
        });
    }
}