package com.scanner.demo.mainApp.homePage.view;

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

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.scanner.demo.mainApp.homePage.adapter.ReceiveLetterCustomAdapter;
import com.scanner.demo.mainApp.homePage.clickEvent.onClickLetterListener;
import com.scanner.demo.mainApp.homePage.model.ReceiveLetterRoot;
import com.scanner.demo.mainApp.homePage.viewmodel.ReceiveLetterVM;
import com.scanner.demo.R;
import com.scanner.demo.databinding.FragmentHomePageBinding;

public class HomePageFragment extends Fragment {
    FragmentHomePageBinding fragmentHomePageBinding;
    ReceiveLetterVM receiveLetterVM;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentHomePageBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_home_page,container,false);
        return fragmentHomePageBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().getFragmentManager().popBackStack();
        receiveLetterVM = new ReceiveLetterVM(getContext());
        fragmentHomePageBinding.setReceiveLetterVM(receiveLetterVM);
        MutableLiveData<ReceiveLetterRoot> mutableLiveData = receiveLetterVM.getReceiveLetterRootMutableLiveData();
        mutableLiveData.observe(getActivity(), new Observer<ReceiveLetterRoot>() {
            @Override
            public void onChanged(ReceiveLetterRoot receiveLetterRoot) {
                receiveLetterVM.setData(receiveLetterRoot.getData());
                fragmentHomePageBinding.setReceiveLetterVM(receiveLetterVM);
                fragmentHomePageBinding.recyReceiveLetter.setAdapter(new ReceiveLetterCustomAdapter(receiveLetterRoot.getData().getList(), getContext(),
                        (letterId, actionId,parentId) -> {
                            Bundle bundle = new Bundle();
                            bundle.putString("actionId",actionId);
                            bundle.putString("id",letterId);
                            bundle.putString("parentId",parentId);
                            bundle.putString("key","home");
                            Navigation.findNavController(fragmentHomePageBinding.recyReceiveLetter).navigate(R.id.action_homePageFragment_to_letterSingleFragment,bundle);
                        }));
            }
        });
        actionMenu();
    }

    private void actionMenu() {
        fragmentHomePageBinding.archiveIcon.setOnClickListener(View ->{
            NavDirections navDirections = HomePageFragmentDirections.actionHomePageFragmentToArchiveFragment();
            Navigation.findNavController(fragmentHomePageBinding.archiveIcon).navigate(navDirections);
        });
        fragmentHomePageBinding.fileManagerIcon.setOnClickListener(View->{
            NavDirections navDirections = HomePageFragmentDirections.actionHomePageFragmentToFileManegerFragment();
            Navigation.findNavController(fragmentHomePageBinding.fileManagerIcon).navigate(navDirections);
        });
        fragmentHomePageBinding.kartableIcon.setOnClickListener(View->{
            NavDirections navDirections = HomePageFragmentDirections.actionHomePageFragmentToKartableFragment();
            Navigation.findNavController(fragmentHomePageBinding.kartableIcon).navigate(navDirections);
        });
    }
}