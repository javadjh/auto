package com.scanner.demo.mainApp.kartable.view;

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

import com.scanner.demo.R;
import com.scanner.demo.databinding.FragmentDraftKartableBinding;
import com.scanner.demo.mainApp.kartable.adapter.DraftLetterCustomAdapter;
import com.scanner.demo.mainApp.kartable.model.DraftResponseRoot;
import com.scanner.demo.mainApp.kartable.viewmodel.DraftKartableVM;

public class DraftKartableFragment extends Fragment {
    FragmentDraftKartableBinding fragmentDraftKartableBinding;
    DraftKartableVM draftKartableVM;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentDraftKartableBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_draft_kartable,container,false);
        return fragmentDraftKartableBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        draftKartableVM = new DraftKartableVM(getContext());
        MutableLiveData<DraftResponseRoot> draftResponseRootMutableLiveData = draftKartableVM.getDraftResponseRootMutableLiveData();
        draftResponseRootMutableLiveData.observe(getActivity(), new Observer<DraftResponseRoot>() {
            @Override
            public void onChanged(DraftResponseRoot draftResponseRoot) {
                draftKartableVM.setData(draftResponseRoot.getData());
                fragmentDraftKartableBinding.setDraftKartableVM(draftKartableVM);
                fragmentDraftKartableBinding.recyDraftKartable.setAdapter(new
                        DraftLetterCustomAdapter(getContext(),draftKartableVM.getData().getList()));
            }
        });
    }
}