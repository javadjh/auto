package com.scanner.demo.mainApp.kartable.upsertLetter.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.scanner.demo.R;
import com.scanner.demo.databinding.FragmentUpsertLetterStepTwoBinding;
import com.scanner.demo.mainApp.kartable.upsertLetter.adapter.CopyCustomAdapter;
import com.scanner.demo.mainApp.kartable.upsertLetter.interfaceEvent.onRemoveCopy;
import com.scanner.demo.mainApp.kartable.upsertLetter.model.CopiesList;
import com.scanner.demo.mainApp.kartable.upsertLetter.model.EventAddFile;
import com.scanner.demo.mainApp.kartable.upsertLetter.model.UpsertLetterRoot;
import com.scanner.demo.mainApp.kartable.upsertLetter.model.receiver;
import com.scanner.demo.mainApp.kartable.upsertLetter.model.sender;
import com.scanner.demo.mainApp.kartable.upsertLetter.viewmodel.UpsertLetterStepTwoVM;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


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
    List<EventAddFile> eventAddFilesSend = new ArrayList<>();
    ChoiseFileBootomSheet choiseFileBootomSheet;
    com.scanner.demo.mainApp.kartable.upsertLetter.model.receiver receiver;
    sender sender;
    String receiverRole;
    String userIdSender,userRoleSender,copyType;
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
        choiseFileBottomSheet();
        sendLetter();
        fragmentUpsertLetterStepTwoBinding.setUpsertLetterStepTwoVM(upsertLetterStepTwoVM);

    }

    private void sendLetter() {
        fragmentUpsertLetterStepTwoBinding.sendLetter.setOnClickListener(View->{
            //generate appendixList
            List<String> appendixList = new ArrayList<>();
            appendixList.clear();
            for (int i = 0 ; i<eventAddFilesSend.size() ; i++){
                appendixList.add(eventAddFilesSend.get(i).getFileId());
            }
            //Confidently
            String confidently = getArguments().getString("confidently");
            //content
            String content = getArguments().getString("descriptionLetter");
            //Copies => copiesLists
            //receiver Object
            receiver = new receiver(receiverRole,userId);
            //sender Object
            sender = new sender(userRoleSender,userIdSender);
            String title = getArguments().getString("letterTitle");
            //Urgent
            String Urgent = getArguments().getString("urgently");
            upsertLetterStepTwoVM.upsertLetter(new UpsertLetterRoot(
                    null,null,null,title,content,Urgent,
                    receiver,sender,null,confidently,appendixList,copiesLists,false));
        });

    }

    private void choiseFileBottomSheet() {
        fragmentUpsertLetterStepTwoBinding.choiseFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choiseFileBootomSheet = new ChoiseFileBootomSheet(eventAddFilesSend, eventAddFiles -> {
                    eventAddFilesSend = eventAddFiles;
                    choiseFileBootomSheet.dismiss();
                });
                choiseFileBootomSheet.show(requireActivity().getSupportFragmentManager(),"chopisFile");
            }
        });
    }

    private void createUserCopyList() {

        fragmentUpsertLetterStepTwoBinding.addCopy.setOnClickListener(View->{
            copiesLists.add(new CopiesList(userIdCopy,copyType,null,userNameCopy));
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
        //getUserReceipt
        fragmentUpsertLetterStepTwoBinding.choiseReceiverBtn.setOnClickListener(View ->{
            SearchUsersBottomSheet searchUsersBottomSheet = new SearchUsersBottomSheet(usersDataList -> {
                fragmentUpsertLetterStepTwoBinding.choiseReceiverBtn.setText(usersDataList.getFullName());
                userId = usersDataList.getId();
                rolesReceiver = usersDataList.getRoles();
                fragmentUpsertLetterStepTwoBinding.postSpinnerReceiver.setItems(rolesReceiver);
            });
            searchUsersBottomSheet.show(requireActivity().getSupportFragmentManager(),"choiseUser");
            fragmentUpsertLetterStepTwoBinding.postSpinnerReceiver.setOnItemSelectedListener((view, position, id, item) -> {
                receiverRole = rolesReceiver.get(position);
            });
        });

        //getUser for Copies
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
                fragmentUpsertLetterStepTwoBinding.copiesForWhat.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                        copyType = copyForWhat.get(position);
                    }
                });
            });
            searchUsersBottomSheet.show(requireActivity().getSupportFragmentManager(),"choiseUserForCopy");
        });
    }

    private void setSelfRole() {
        sharedPreferences = requireActivity().getSharedPreferences("information", Context.MODE_PRIVATE);
        roles = Collections.singletonList(sharedPreferences.getString("rolse", null));
        userIdSender = sharedPreferences.getString("userId", null);
        postSpinnerSender.setItems(roles);
        postSpinnerSender.setOnItemSelectedListener((view, position, id, item) -> userRoleSender = roles.get(position));
    }
}