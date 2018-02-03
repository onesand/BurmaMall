package com.burmamall.burmamall.model;

/**
 * Created by sand on 2018/2/3.
 */

public class FlashDealsModel {

    /**
     * id : 218
     * name : 法国进口红酒 塞莱斯城堡干红葡萄酒 整箱装 750ml*6瓶
     * img : upload/2016/01/22/568cccfdN6f817ec5.jpg
     * sell_price : 238.00
     * market_price : 3998.00
     */

    private String id;
    private String name;
    private String img;
    private String sell_price;
    private String market_price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSell_price() {
        return sell_price;
    }

    public void setSell_price(String sell_price) {
        this.sell_price = sell_price;
    }

    public String getMarket_price() {
        return market_price;
    }

    public void setMarket_price(String market_price) {
        this.market_price = market_price;
    }
}
