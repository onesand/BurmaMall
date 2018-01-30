package com.burmamall.burmamall.model;

/**
 * Created by sand on 2018/1/30.
 */

public class BannerModel {

    /**
     * id : 1
     * type : 1
     * img_path : upload/2018/01/30/20180130164743997.png
     * link : http://www.baidu.com
     */

    private String id;
    private String type;
    private String img_path;
    private String link;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "BannerModel{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", img_path='" + img_path + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}


