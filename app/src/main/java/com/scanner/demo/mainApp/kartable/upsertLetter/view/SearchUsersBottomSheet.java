package com.scanner.demo.mainApp.kartable.upsertLetter.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.scanner.demo.R;
import com.scanner.demo.databinding.FragmentSearchUsersBottomSheetBinding;
import com.scanner.demo.mainApp.kartable.upsertLetter.adapter.UsersCustomAdapter;
import com.scanner.demo.mainApp.kartable.upsertLetter.interfaceEvent.onclick;
import com.scanner.demo.mainApp.kartable.upsertLetter.model.UsersDataList;
import com.scanner.demo.mainApp.kartable.upsertLetter.model.UsersResponseRoot;
import com.scanner.demo.mainApp.kartable.upsertLetter.viewmodel.UsersBottomSheetVM;

public class SearchUsersBottomSheet extends BottomSheetDialogFragment {
    onclick onclick;

    public SearchUsersBottomSheet(com.scanner.demo.mainApp.kartable.upsertLetter.interfaceEvent.onclick onclick) {
        this.onclick = onclick;
    }

    FragmentSearchUsersBottomSheetBinding fragmentSearchUsersBottomSheetBinding;
    UsersBottomSheetVM usersBottomSheetVM;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentSearchUsersBottomSheetBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_search_users_bottom_sheet,container,false);
        return fragmentSearchUsersBottomSheetBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        usersBottomSheetVM = new UsersBottomSheetVM(getContext());
        MutableLiveData<UsersResponseRoot> usersResponseRootMutableLiveData = usersBottomSheetVM.getUsersResponseRootMutableLiveData();
        usersResponseRootMutableLiveData.observe(getActivity(), new Observer<UsersResponseRoot>() {
            @Override
            public void onChanged(UsersResponseRoot usersResponseRoot) {
                usersBottomSheetVM.setData(usersResponseRoot.getData());
                fragmentSearchUsersBottomSheetBinding.recyUsers.setAdapter(new UsersCustomAdapter(usersResponseRoot.getData(), getContext(),
                        usersDataList -> {
                    onclick.userInformation(usersDataList);
                    dismiss();
                }));
                fragmentSearchUsersBottomSheetBinding.setUsersBottomSheetVM(usersBottomSheetVM);
            }
        });
    }
}