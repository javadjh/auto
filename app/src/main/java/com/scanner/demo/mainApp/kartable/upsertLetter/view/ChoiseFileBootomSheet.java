package com.scanner.demo.mainApp.kartable.upsertLetter.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.scanner.demo.R;
import com.scanner.demo.databinding.FragmentChoiseFileBootomSheetBinding;
import com.scanner.demo.mainApp.fileManager.model.FileManagerModelResponseRoot;
import com.scanner.demo.mainApp.kartable.upsertLetter.adapter.AddFileCustomAdapter;
import com.scanner.demo.mainApp.kartable.upsertLetter.adapter.ChoiseFileCustomAdapter;
import com.scanner.demo.mainApp.kartable.upsertLetter.interfaceEvent.onClickAddFile;
import com.scanner.demo.mainApp.kartable.upsertLetter.interfaceEvent.onClickAddFileFinal;
import com.scanner.demo.mainApp.kartable.upsertLetter.model.EventAddFile;
import com.scanner.demo.mainApp.kartable.upsertLetter.viewmodel.ChoiseFileBottomSheetVM;

import java.util.ArrayList;
import java.util.List;

public class ChoiseFileBootomSheet extends BottomSheetDialogFragment {
    FragmentChoiseFileBootomSheetBinding fragmentChoiseFileBootomSheetBinding;
    ChoiseFileBottomSheetVM choiseFileBottomSheetVM;
    RecyclerView recyFileAdd;
    AddFileCustomAdapter addFileCustomAdapter;
    List<EventAddFile> eventAddFiles = new ArrayList<>();
    onClickAddFileFinal onClickAddFileFinal;

    public ChoiseFileBootomSheet(List<EventAddFile> eventAddFiles, com.scanner.demo.mainApp.kartable.upsertLetter.interfaceEvent.onClickAddFileFinal onClickAddFileFinal) {
        this.eventAddFiles = eventAddFiles;
        this.onClickAddFileFinal = onClickAddFileFinal;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentChoiseFileBootomSheetBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_choise_file_bootom_sheet,container,false);
        recyFileAdd = fragmentChoiseFileBootomSheetBinding.recyFileAdd;
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
        fragmentChoiseFileBootomSheetBinding.finishChoiseFile.setOnClickListener(View->{
            onClickAddFileFinal.addFileFinal(eventAddFiles);
        });
    }

    private void getFiles(String fileName) {
        choiseFileBottomSheetVM = new ChoiseFileBottomSheetVM(getContext(),fileName);
        removeFileFromList();
        recyFileAdd.setAdapter(addFileCustomAdapter);
        addFileCustomAdapter.notifyDataSetChanged();
        MutableLiveData<FileManagerModelResponseRoot> fileManagerModelResponseRootMutableLiveData = choiseFileBottomSheetVM.getFileManagerModelResponseRootMutableLiveData();
        fileManagerModelResponseRootMutableLiveData.observe(getActivity(), fileManagerModelResponseRoot -> {
            choiseFileBottomSheetVM.setData(fileManagerModelResponseRoot.getData());
            addFileFromList();
            fragmentChoiseFileBootomSheetBinding.setChoiseFileBottomSheetVM(choiseFileBottomSheetVM);
        });
    }

    private void addFileFromList() {
        fragmentChoiseFileBootomSheetBinding.recyChoiseFile.setAdapter(
                new ChoiseFileCustomAdapter(getContext(), choiseFileBottomSheetVM.getData().getList(), new onClickAddFile() {
                    @Override
                    public void getFileAction(EventAddFile eventAddFile) {
                        eventAddFiles.add(eventAddFile);
                        recyFileAdd.setAdapter(addFileCustomAdapter);
                        addFileCustomAdapter.notifyDataSetChanged();
                        Toast.makeText(getContext(), eventAddFiles.size() + "", Toast.LENGTH_SHORT).show();
                    }
                }));
    }

    private void removeFileFromList() {
        addFileCustomAdapter = new AddFileCustomAdapter(getContext(), eventAddFiles, new onClickAddFile() {
            @Override
            public void getFileAction(EventAddFile eventAddFile) {
                eventAddFiles.remove(eventAddFile);
                addFileCustomAdapter.notifyDataSetChanged();
                Toast.makeText(getContext(), eventAddFiles.size() + "", Toast.LENGTH_SHORT).show();
            }
        });
    }
}