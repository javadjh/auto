package com.scanner.demo.mainApp.kartable.upsertLetter.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
import com.scanner.demo.databinding.FragmentUpsertLetterBinding;
import com.scanner.demo.mainApp.kartable.upsertLetter.viewmodel.UpsertLetterStepOneVM;

public class UpsertLetterFragment extends Fragment {
    FragmentUpsertLetterBinding fragmentUpsertLetterBinding;
    private IARE_Toolbar mToolbar;
    private AREditText mEditText;
    UpsertLetterStepOneVM upsertLetterStepOneVM;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentUpsertLetterBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_upsert_letter,container,false);
        return fragmentUpsertLetterBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        upsertLetterStepOneVM = new UpsertLetterStepOneVM(getContext());
        fragmentUpsertLetterBinding.setUpsertLetterStepOneVM(upsertLetterStepOneVM);
        mToolbar = fragmentUpsertLetterBinding.areToolbar;
        mEditText = fragmentUpsertLetterBinding.arEditText;
        fragmentUpsertLetterBinding.goToStepTwoAddLetter.setOnClickListener(View ->{
            Navigation.findNavController(fragmentUpsertLetterBinding.goToStepTwoAddLetter).navigate(R.id.action_upsertLetterFragment_to_upsertLetterStepTwoFragment);
        });
        initToolbar();
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