package com.burmamall.burmamall.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.burmamall.burmamall.utils.TUtil;
import com.burmamall.burmamall.viewmodel.IViewModel;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by sand on 2018/1/24.
 */

public abstract class BaseActivity<ViewModel extends IViewModel> extends AppCompatActivity{

    protected ViewModel mViewModel;
    protected CompositeDisposable mCompositeDisposable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCompositeDisposable = new CompositeDisposable();
        mViewModel = getViewModel();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mViewModel != null){
            mViewModel.onDestroy();
            mViewModel = null;
        }
        if (mCompositeDisposable != null){
            mCompositeDisposable.clear();
        }
    }

    public ViewModel getViewModel() {
        return TUtil.get(this);
    }

    protected boolean addDisposable(@NonNull Disposable disposable){
        if (mCompositeDisposable != null){
            return mCompositeDisposable.add(disposable);
        }
        return false;
    }

    protected boolean removeDisposable(@NonNull Disposable disposable){
        if (mCompositeDisposable != null){
            return mCompositeDisposable.remove(disposable);
        }
        return false;
    }
}
