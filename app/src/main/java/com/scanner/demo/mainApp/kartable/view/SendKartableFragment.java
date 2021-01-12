package com.scanner.demo.mainApp.kartable.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scanner.demo.R;
import com.scanner.demo.databinding.FragmentSendKartableBinding;
import com.scanner.demo.mainApp.homePage.adapter.ReceiveLetterCustomAdapter;
import com.scanner.demo.mainApp.homePage.clickEvent.onClickLetterListener;
import com.scanner.demo.mainApp.homePage.model.ReceiveLetterRoot;
import com.scanner.demo.mainApp.kartable.searchKartable.model.OnEventListennerSend;
import com.scanner.demo.mainApp.kartable.viewmodel.SendKartableVM;

public class SendKartableFragment extends Fragment {
    FragmentSendKartableBinding fragmentSendKartableBinding;
    SendKartableVM sendKartableVM;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentSendKartableBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_send_kartable,container,false);
        return fragmentSendKartableBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sendKartableVM = new SendKartableVM(getContext(),
                OnEventListennerSend.title,
                OnEventListennerSend.receiverRole,
                OnEventListennerSend.receiverName,
                OnEventListennerSend.confidentiality,
                OnEventListennerSend.urgency,
                OnEventListennerSend.from,
                OnEventListennerSend.to);
        MutableLiveData<ReceiveLetterRoot> sendLetterRootMutableLiveData = sendKartableVM.getSendLetterRootMutableLiveData();
        sendLetterRootMutableLiveData.observe(getActivity(), new Observer<ReceiveLetterRoot>() {
            @Override
            public void onChanged(ReceiveLetterRoot receiveLetterRoot) {
                sendKartableVM.setData(receiveLetterRoot.getData());
                fragmentSendKartableBinding.setSendKartableVM(sendKartableVM);
                fragmentSendKartableBinding.recySendLetterKartable.setAdapter(new ReceiveLetterCustomAdapter(
                        receiveLetterRoot.getData().getList(), getContext(), new onClickLetterListener() {
                    @Override
                    public void onClickLetterListenetAdapter(String letterId) {
                        Bundle bundle = new Bundle();
                        bundle.putString("id",letterId);
                        bundle.putString("key","kartable");
                        Navigation.findNavController(fragmentSendKartableBinding.recySendLetterKartable).navigate(R.id.action_kartableFragment_to_letterSingleFragment,bundle);
                    }
                }
                ));
            }
        });
    }
}