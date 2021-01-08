package com.scanner.demo.mainApp.fileManager.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scanner.demo.R;
import com.scanner.demo.databinding.FragmentFileManegerBinding;
import com.scanner.demo.mainApp.fileManager.adapter.FileUserCustomAdapter;
import com.scanner.demo.mainApp.fileManager.model.FileManagerModelResponseRoot;
import com.scanner.demo.mainApp.fileManager.viewmodel.FileManagerVM;
import com.scanner.demo.mainApp.homePage.view.HomePageFragmentDirections;
import com.scanner.demo.mainApp.letterSingle.adapter.AppendixCustomAdapter;

public class FileManegerFragment extends Fragment {
    FragmentFileManegerBinding fragmentFileManegerBinding;
    FileManagerVM fileManagerVM;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentFileManegerBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_file_maneger,container,false);
        return fragmentFileManegerBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().getFragmentManager().popBackStack();
        fileManagerVM = new FileManagerVM(getContext());
        fragmentFileManegerBinding.setFileManagerVM(fileManagerVM);

        MutableLiveData<FileManagerModelResponseRoot> fileManagerModelResponseRootMutableLiveData = fileManagerVM.getFileManagerModelResponseRootMutableLiveData();
        fileManagerModelResponseRootMutableLiveData.observe(getActivity(), new Observer<FileManagerModelResponseRoot>() {
            @Override
            public void onChanged(FileManagerModelResponseRoot fileManagerModelResponseRoot) {
                fragmentFileManegerBinding.recyFiles.setAdapter(new FileUserCustomAdapter(getContext(),fileManagerModelResponseRoot.getData().getList()));
            }
        });

        clickEvent();
        MenuAction();
    }

    private void clickEvent() {
        fragmentFileManegerBinding.addNewFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(fragmentFileManegerBinding.addNewFile).navigate(R.id.action_fileManegerFragment_to_mainActivity2);
            }
        });
    }

    private void MenuAction() {
        fragmentFileManegerBinding.archiveIcon.setOnClickListener(View ->{
            NavDirections navDirections = FileManegerFragmentDirections.actionFileManegerFragmentToArchiveFragment();
            Navigation.findNavController(fragmentFileManegerBinding.archiveIcon).navigate(navDirections);
        });
        fragmentFileManegerBinding.kartableIcon.setOnClickListener(View->{
            NavDirections navDirections = FileManegerFragmentDirections.actionFileManegerFragmentToKartableFragment();
            Navigation.findNavController(fragmentFileManegerBinding.kartableIcon).navigate(navDirections);
            getActivity().getFragmentManager().popBackStack();
        });
        fragmentFileManegerBinding.homePageIcon.setOnClickListener(View->{
            NavDirections navDirections = FileManegerFragmentDirections.actionFileManegerFragmentToHomePageFragment();
            Navigation.findNavController(fragmentFileManegerBinding.kartableIcon).navigate(navDirections);
            getActivity().getFragmentManager().popBackStack();
        });
    }

}