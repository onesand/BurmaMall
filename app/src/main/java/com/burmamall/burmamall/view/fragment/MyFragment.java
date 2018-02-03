package com.burmamall.burmamall.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.burmamall.burmamall.R;
import com.burmamall.burmamall.config.LauchConfig;
import com.burmamall.burmamall.factory.ViewModelFactory;
import com.burmamall.burmamall.view.BaseActivity;
import com.burmamall.burmamall.viewmodel.my.MyModel;
import com.burmamall.burmamall.widget.RoundImageView;

/**
 * Created by sand on 2018/1/27.
 */

public class MyFragment extends BaseFragment<MyModel> {

    private RoundImageView  userIconIv;
    private TextView userNameTv;
    private View view;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_my,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        userIconIv = (RoundImageView) view.findViewById(R.id.my_fragment_user_icon);
        userNameTv = (TextView) view.findViewById(R.id.my_fragment_user_name);

        mViewModel.initUserInfoData(userIconIv,userNameTv);

        userIconIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LauchConfig.toLoginActivity(getActivity());
            }
        });
    }

    @Override
    public MyModel getViewModel() {
        return ViewModelFactory.factory().getMyModel();
    }
}
