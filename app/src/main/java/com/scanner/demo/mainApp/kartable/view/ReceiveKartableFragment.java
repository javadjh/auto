package com.scanner.demo.mainApp.kartable.view;

import android.os.Bundle;

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
import com.scanner.demo.databinding.FragmentReceiveKartableBinding;
import com.scanner.demo.mainApp.homePage.adapter.ReceiveLetterCustomAdapter;
import com.scanner.demo.mainApp.homePage.clickEvent.onClickLetterListener;
import com.scanner.demo.mainApp.homePage.model.ReceiveLetterRoot;
import com.scanner.demo.mainApp.homePage.view.HomePageFragmentDirections;
import com.scanner.demo.mainApp.homePage.viewmodel.ReceiveLetterVM;
import com.scanner.demo.mainApp.kartable.viewmodel.ReceiveKartableVM;

public class ReceiveKartableFragment extends Fragment {
    FragmentReceiveKartableBinding fragmentReceiveKartableBinding;
    ReceiveKartableVM receiveKartableVM;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentReceiveKartableBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_receive_kartable,container,false);
        return fragmentReceiveKartableBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getReceiveLetterKartable();
    }

    private void getReceiveLetterKartable() {
        receiveKartableVM = new ReceiveKartableVM(getContext());
        MutableLiveData<ReceiveLetterRoot> mutableLiveData = receiveKartableVM.getReceiveLetterRootMutableLiveData();
        mutableLiveData.observe(getActivity(), new Observer<ReceiveLetterRoot>() {
            @Override
            public void onChanged(ReceiveLetterRoot receiveLetterRoot) {
                receiveKartableVM.setData(receiveLetterRoot.getData());
                fragmentReceiveKartableBinding.setReceiveKartableVM(receiveKartableVM);
                fragmentReceiveKartableBinding.recyReceiveKartable.setAdapter(new ReceiveLetterCustomAdapter(receiveLetterRoot.getData().getList(), getContext(),
                        new onClickLetterListener() {
                            @Override
                            public void onClickLetterListenetAdapter(String letterId) {
                                Bundle bundle = new Bundle();
                                bundle.putString("id",letterId);
                                bundle.putString("key","kartable");
                                Navigation.findNavController(fragmentReceiveKartableBinding.recyReceiveKartable).navigate(R.id.action_kartableFragment_to_letterSingleFragment,bundle);
                            }
                        }));
            }
        });
    }


}