package com.scanner.demo.mainApp.letterSingle.action.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.chinalwb.are.AREditText;
import com.chinalwb.are.styles.toolbar.IARE_Toolbar;
import com.chinalwb.are.styles.toolitems.ARE_ToolItem_AlignmentCenter;
import com.chinalwb.are.styles.toolitems.ARE_ToolItem_AlignmentLeft;
import com.chinalwb.are.styles.toolitems.ARE_ToolItem_AlignmentRight;
import com.chinalwb.are.styles.toolitems.ARE_ToolItem_Bold;
import com.chinalwb.are.styles.toolitems.ARE_ToolItem_Hr;
import com.chinalwb.are.styles.toolitems.ARE_ToolItem_Italic;
import com.chinalwb.are.styles.toolitems.ARE_ToolItem_Strikethrough;
import com.chinalwb.are.styles.toolitems.ARE_ToolItem_Underline;
import com.chinalwb.are.styles.toolitems.IARE_ToolItem;
import com.scanner.demo.R;
import com.scanner.demo.databinding.FragmentActionLetterBinding;
import com.scanner.demo.mainApp.kartable.upsertLetter.interfaceEvent.onClickAddFileFinal;
import com.scanner.demo.mainApp.kartable.upsertLetter.model.EventAddFile;
import com.scanner.demo.mainApp.kartable.upsertLetter.view.ChoiseFileBootomSheet;
import com.scanner.demo.mainApp.letterSingle.action.model.UserChoise;
import com.scanner.demo.mainApp.letterSingle.action.model.ActionBody;
import com.scanner.demo.mainApp.letterSingle.action.viewmodel.ActionVM;

import java.util.ArrayList;
import java.util.List;

public class ActionLetterFragment extends Fragment {
    FragmentActionLetterBinding fragmentActionLetterBinding;
    private IARE_Toolbar mToolbar;
    private AREditText mEditText;
    private Button choiseUser,choiseFiles,sendAction;
    List<UserChoise> userChoises = new ArrayList<>();
    List<EventAddFile> eventAddFilesMain = new ArrayList<>();
    SelectUserBottomSheet selectUserBottomSheet;
    ChoiseFileBootomSheet choiseFileBootomSheet;
    //valueForSendToServer
    String letterId,actionId,type,paraph;
    ActionVM actionVM;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentActionLetterBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_action_letter,container,false);
        setViewBind();
        return fragmentActionLetterBinding.getRoot();
    }

    private void setViewBind() {
        mToolbar = fragmentActionLetterBinding.areToolbar;
        mEditText = fragmentActionLetterBinding.arEditText;
        choiseUser = fragmentActionLetterBinding.choiseUser;
        choiseFiles = fragmentActionLetterBinding.choiseFiles;
        sendAction = fragmentActionLetterBinding.sendAction;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initToolbar();
        setUserChoiserBottomSheet();
        choiseFile();
        sendActionBtn();
    }

    private void sendActionBtn() {
        sendAction.setOnClickListener(View->{
            //letter id
            letterId = getArguments().getString("id");
            //action id
            actionId = getArguments().getString("actionId");
            //set type
            type = "FORWARD";
            //set paraph
            paraph = mEditText.getHtml();
            //generate userList
            List<String> users = new ArrayList<>();
            users.clear();
            for (int i = 0 ; i< userChoises.size() ; i++){
                users.add(userChoises.get(i).getUserId());
            }
            //generate fileList
            List<String> files = new ArrayList<>();
            files.clear();
            for (int i = 0 ; i<eventAddFilesMain.size() ; i++){
                files.add(eventAddFilesMain.get(i).getFileId());
            }
            ActionBody actionBody = new ActionBody(letterId,actionId,type,paraph,users,files);
            actionVM = new ActionVM(getContext());
            actionVM.sendAction(actionBody);
            fragmentActionLetterBinding.setActionVM(actionVM);
        });
    }

    private void choiseFile() {
        choiseFiles.setOnClickListener(View->{
            choiseFileBootomSheet = new ChoiseFileBootomSheet(eventAddFilesMain, new onClickAddFileFinal() {
                @Override
                public void addFileFinal(List<EventAddFile> eventAddFiles) {
                    eventAddFilesMain = eventAddFiles;
                    choiseFileBootomSheet.dismiss();
                }
            });
            choiseFileBootomSheet.show(requireActivity().getSupportFragmentManager(),"choiseFile");
        });
    }

    private void setUserChoiserBottomSheet() {
        choiseUser.setOnClickListener(View->{
             selectUserBottomSheet= new SelectUserBottomSheet(userChoise -> {
                 userChoises = userChoise;
                 selectUserBottomSheet.dismiss();
             },userChoises);
            selectUserBottomSheet.show(requireActivity().getSupportFragmentManager(),"choiseUser");
        });
    }

    private void initToolbar() {
        mEditText.setBackgroundColor(getResources().getColor(R.color.lightBlack));
        ARE_ToolItem_Bold bold = new ARE_ToolItem_Bold();
        IARE_ToolItem italic = new ARE_ToolItem_Italic();
        IARE_ToolItem underline = new ARE_ToolItem_Underline();
        IARE_ToolItem strikethrough = new ARE_ToolItem_Strikethrough();
        IARE_ToolItem hr = new ARE_ToolItem_Hr();
        IARE_ToolItem left = new ARE_ToolItem_AlignmentLeft();
        IARE_ToolItem center = new ARE_ToolItem_AlignmentCenter();
        IARE_ToolItem right = new ARE_ToolItem_AlignmentRight();
        mToolbar.addToolbarItem(bold);
        mToolbar.addToolbarItem(italic);
        mToolbar.addToolbarItem(underline);
        mToolbar.addToolbarItem(strikethrough);
        mToolbar.addToolbarItem(hr);
        mToolbar.addToolbarItem(left);
        mToolbar.addToolbarItem(center);
        mToolbar.addToolbarItem(right);
        mEditText.setToolbar(mToolbar);
    }
}