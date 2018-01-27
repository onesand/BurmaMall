package com.burmamall.burmamall.factory;

/**
 * Created by sand on 2018/1/24.
 */

public class ViewModelFactory {

    private static IViewModelFactory mFactory = new RootViewModelFactory();

    public static IViewModelFactory factory(){return mFactory;}
}
