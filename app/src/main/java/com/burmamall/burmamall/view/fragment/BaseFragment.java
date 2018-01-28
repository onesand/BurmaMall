package com.burmamall.burmamall.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.burmamall.burmamall.R;
import com.burmamall.burmamall.utils.TUtil;
import com.burmamall.burmamall.viewmodel.IViewModel;
import com.jaeger.library.StatusBarUtil;

/**
 * Created by sand on 2018/1/28.
 */

public class BaseFragment<ViewModel extends IViewModel> extends Fragment{

    protected ViewModel mViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setColor(getActivity(), getResources().getColor(R.color.title),0);
        mViewModel = getViewModel();
    }

    public ViewModel getViewModel() {
        return TUtil.get(this);
    }
}
