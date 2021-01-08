package com.scanner.demo.mainApp.kartable.upsertLetter.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.jaredrummler.materialspinner.MaterialSpinner;
import com.scanlibrary.ScanActivity;
import com.scanlibrary.ScanConstants;
import com.scanner.demo.MainActivity;
import com.scanner.demo.R;
import com.scanner.demo.databinding.FragmentUpsertLetterStepTwoBinding;
import com.scanner.demo.mainApp.kartable.upsertLetter.adapter.CopyCustomAdapter;
import com.scanner.demo.mainApp.kartable.upsertLetter.interfaceEvent.onRemoveCopy;
import com.scanner.demo.mainApp.kartable.upsertLetter.interfaceEvent.onclick;
import com.scanner.demo.mainApp.kartable.upsertLetter.model.CopiesList;
import com.scanner.demo.mainApp.kartable.upsertLetter.model.UsersDataList;
import com.scanner.demo.mainApp.kartable.upsertLetter.viewmodel.UpsertLetterStepTwoVM;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.chinalwb.are.styles.toolitems.styles.ARE_Style_At.REQUEST_CODE;

public class UpsertLetterStepTwoFragment extends Fragment {
    FragmentUpsertLetterStepTwoBinding fragmentUpsertLetterStepTwoBinding;
    UpsertLetterStepTwoVM upsertLetterStepTwoVM;
    SharedPreferences sharedPreferences;
    MaterialSpinner postSpinnerSender;
    List<String> roles = new ArrayList<>();
    List<String> rolesReceiver = new ArrayList<>();
    List<String> copyForWhat = new ArrayList<>();
    String userId;
    String userNameCopy,userIdCopy;
    List<CopiesList> copiesLists = new ArrayList<>();
    CopyCustomAdapter copyCustomAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentUpsertLetterStepTwoBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_upsert_letter_step_two,container,false);
        postSpinnerSender = fragmentUpsertLetterStepTwoBinding.postSpinnerSender;
        return fragmentUpsertLetterStepTwoBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        upsertLetterStepTwoVM = new UpsertLetterStepTwoVM(getContext());
        getUsersBottomSheet();
        createUserCopyList();
        setSelfRole();
        fragmentUpsertLetterStepTwoBinding.choiseFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChoiseFileBootomSheet choiseFileBootomSheet = new ChoiseFileBootomSheet();
                choiseFileBootomSheet.show(requireActivity().getSupportFragmentManager(),"chopisFile");
            }
        });
        fragmentUpsertLetterStepTwoBinding.setUpsertLetterStepTwoVM(upsertLetterStepTwoVM);

    }


    private void createUserCopyList() {
        fragmentUpsertLetterStepTwoBinding.addCopy.setOnClickListener(View->{
            copiesLists.add(new CopiesList(userIdCopy,"test",null,userNameCopy));
            copyCustomAdapter = new CopyCustomAdapter(getContext(), copiesLists, new onRemoveCopy() {
                @Override
                public void copyInformation(CopiesList copiesList) {
                    copiesLists.remove(copiesList);
                    copyCustomAdapter.notifyDataSetChanged();
                    fragmentUpsertLetterStepTwoBinding.recyCopyLetter.setAdapter(copyCustomAdapter);
                }
            });
            fragmentUpsertLetterStepTwoBinding.recyCopyLetter.setAdapter(copyCustomAdapter);
        });
    }

    private void getUsersBottomSheet() {
        fragmentUpsertLetterStepTwoBinding.choiseReceiverBtn.setOnClickListener(View ->{
            SearchUsersBottomSheet searchUsersBottomSheet = new SearchUsersBottomSheet(usersDataList -> {
                fragmentUpsertLetterStepTwoBinding.choiseReceiverBtn.setText(usersDataList.getFullName());
                userId = usersDataList.getId();
                rolesReceiver = usersDataList.getRoles();
                fragmentUpsertLetterStepTwoBinding.postSpinnerReceiver.setItems(rolesReceiver);
            });
            searchUsersBottomSheet.show(requireActivity().getSupportFragmentManager(),"choiseUser");
        });
        fragmentUpsertLetterStepTwoBinding.choiseUserForCopy.setOnClickListener(View->{
            copyForWhat.clear();
            SearchUsersBottomSheet searchUsersBottomSheet = new SearchUsersBottomSheet(usersDataList -> {
                fragmentUpsertLetterStepTwoBinding.choiseUserForCopy.setText(usersDataList.getFullName());
                userNameCopy = usersDataList.getFullName();
                userIdCopy = usersDataList.getId();
                copyForWhat.add("اقدام");
                copyForWhat.add("بررسی");
                copyForWhat.add("اطلاع");
                fragmentUpsertLetterStepTwoBinding.copiesForWhat.setItems(copyForWhat);
            });
            searchUsersBottomSheet.show(requireActivity().getSupportFragmentManager(),"choiseUserForCopy");
        });
    }

    private void setSelfRole() {
        sharedPreferences = requireActivity().getSharedPreferences("information", Context.MODE_PRIVATE);
        roles = Collections.singletonList(sharedPreferences.getString("rolse", null));
        postSpinnerSender.setItems(roles);
    }
}