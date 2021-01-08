package com.scanner.demo.mainApp.letterSingle.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.scanner.demo.R;
import com.scanner.demo.databinding.FragmentLetterSingleBinding;
import com.scanner.demo.mainApp.homePage.view.HomePageFragmentDirections;
import com.scanner.demo.mainApp.letterSingle.adapter.AppendixCustomAdapter;
import com.scanner.demo.mainApp.letterSingle.adapter.CopiesCustomAdapter;
import com.scanner.demo.mainApp.letterSingle.model.LetterSingleRoot;
import com.scanner.demo.mainApp.letterSingle.viewmodel.LetterSinleVM;

import java.util.Objects;

public class LetterSingleFragment extends Fragment {
    FragmentLetterSingleBinding fragmentLetterSingleBinding;
    private String letterId;
    LetterSinleVM letterSinleVM;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentLetterSingleBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_letter_single,container,false);
        return fragmentLetterSingleBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        closePage();
        letterId = getArguments().getString("id");
        getPageData();
    }

    private void getPageData() {
        letterSinleVM = new LetterSinleVM(getContext(),letterId);
        MutableLiveData<LetterSingleRoot> mutableLiveData = letterSinleVM.getSingleRootMutableLiveData();
        mutableLiveData.observe(getActivity(), new Observer<LetterSingleRoot>() {
            @Override
            public void onChanged(LetterSingleRoot letterSingleRoot) {
                letterSinleVM.setData(letterSingleRoot.getData());
                fragmentLetterSingleBinding.setLetterSinleVM(letterSinleVM);
                fragmentLetterSingleBinding.letterContent.setHtml(letterSingleRoot.getData().getContent());
                //set Adapter
                fragmentLetterSingleBinding.recyCopies.setAdapter(new CopiesCustomAdapter(getContext(),letterSingleRoot.getData().getCopies()));
                fragmentLetterSingleBinding.recyAppendix.setAdapter(new AppendixCustomAdapter(getContext(),letterSingleRoot.getData().getAppendixes()));
            }
        });
    }

    private void closePage() {
        fragmentLetterSingleBinding.closeLetterSingle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections navDirections = null;
                switch (Objects.requireNonNull(requireArguments().getString("key"))){
                    case "home":
                        navDirections = LetterSingleFragmentDirections.actionLetterSingleFragmentToHomePageFragment2();
                        break;
                    case "kartable":
                        navDirections = LetterSingleFragmentDirections.actionLetterSingleFragmentToKartableFragment();
                        break;
                }
                assert navDirections != null;
                Navigation.findNavController(fragmentLetterSingleBinding.closeLetterSingle).navigate(navDirections);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(getContext(), "text" + data.getStringExtra("key"), Toast.LENGTH_SHORT).show();
    }
}