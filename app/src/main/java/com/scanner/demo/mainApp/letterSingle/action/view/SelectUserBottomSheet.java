package com.scanner.demo.mainApp.letterSingle.action.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.scanner.demo.R;
import com.scanner.demo.databinding.FragmentSelectUserBinding;
import com.scanner.demo.mainApp.kartable.upsertLetter.adapter.UsersCustomAdapter;
import com.scanner.demo.mainApp.kartable.upsertLetter.interfaceEvent.onclick;
import com.scanner.demo.mainApp.kartable.upsertLetter.model.UsersDataList;
import com.scanner.demo.mainApp.kartable.upsertLetter.model.UsersResponseRoot;
import com.scanner.demo.mainApp.letterSingle.action.adapter.UserSelectedCustomAdapter;
import com.scanner.demo.mainApp.letterSingle.action.model.UserChoise;
import com.scanner.demo.mainApp.letterSingle.action.onClickEvent.onRemoveChoiseUserClick;
import com.scanner.demo.mainApp.letterSingle.action.onClickEvent.onUserListChoisedListener;
import com.scanner.demo.mainApp.letterSingle.action.viewmodel.ChoiseUserVM;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SelectUserBottomSheet extends BottomSheetDialogFragment {
    onUserListChoisedListener onUserListChoisedListener;
    FragmentSelectUserBinding fragmentSelectUserBinding;
    ChoiseUserVM choiseUserVM;
    RecyclerView recyUsers;
    List<UserChoise> userChoises = new ArrayList<>();
    UserSelectedCustomAdapter userSelectedCustomAdapter;
    RecyclerView userChoised;
    TextView doneUsersChoised;

    public SelectUserBottomSheet(com.scanner.demo.mainApp.letterSingle.action.onClickEvent.onUserListChoisedListener onUserListChoisedListener, List<UserChoise> userChoises) {
        this.onUserListChoisedListener = onUserListChoisedListener;
        this.userChoises = userChoises;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentSelectUserBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_select_user,container,false);
        recyUsers = fragmentSelectUserBinding.recyUsers;
        userChoised = fragmentSelectUserBinding.userChoised;
        doneUsersChoised = fragmentSelectUserBinding.doneUsersChoised;
        return fragmentSelectUserBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //set VM
        choiseUserVM = new ChoiseUserVM(getContext());
        MutableLiveData<UsersResponseRoot> usersResponseRootMutableLiveData = choiseUserVM.getUsersResponseRootMutableLiveData();
        usersResponseRootMutableLiveData.observe(requireActivity(), usersResponseRoot ->{
            fragmentSelectUserBinding.setUsersResponseRoot(usersResponseRoot);
            setChoise(usersResponseRoot);
        });
        setListUsersChoisedAdapter();
        userChoised.setAdapter(userSelectedCustomAdapter);
        doneUsersChoised.setOnClickListener(View->{
            onUserListChoisedListener.onChoisedListener(userChoises);
        });

    }

    private void setChoise(UsersResponseRoot usersResponseRoot) {
        recyUsers.setAdapter(new UsersCustomAdapter(usersResponseRoot.getData(), getContext(), new onclick() {
            @Override
            public void userInformation(UsersDataList usersDataList) {
                userChoises.add(new UserChoise(usersDataList.getId(),usersDataList.getFullName()));
                userSelectedCustomAdapter.notifyDataSetChanged();
            }
        }));
    }

    private void setListUsersChoisedAdapter() {
        userSelectedCustomAdapter = new UserSelectedCustomAdapter(getContext(), userChoises, new onRemoveChoiseUserClick() {
            @Override
            public void removeUserChoised(UserChoise userChoise) {
                userChoises.remove(userChoise);
                userSelectedCustomAdapter.notifyDataSetChanged();
            }
        });
    }
}