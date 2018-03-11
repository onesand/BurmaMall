package com.burmamall.burmamall.model;

import java.util.List;

/**
 * Created by sand on 2018/2/3.
 */

public class HomeCommodityModel<T> {

    private int type;

    private List<T> data;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
