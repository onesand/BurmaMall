package com.burmamall.burmamall.model;

/**
 * Created by sand on 2018/2/4.
 */

public class ADModel {


    /**
     * id : 1
     * name : 平台推荐
     * type : 3
     * img_path : upload/2018/01/31/20180131175032964.jpg
     * link :
     */

    private String id;
    private String name;
    private String type;
    private String img_path;
    private String link;

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
}
