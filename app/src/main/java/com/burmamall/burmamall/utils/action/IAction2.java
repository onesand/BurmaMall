package com.burmamall.burmamall.utils.action;

/**
 * Created by melorin on 2017/11/14.
 */
public interface IAction2<T, R> {

    void invoke(T t, R r);
}
