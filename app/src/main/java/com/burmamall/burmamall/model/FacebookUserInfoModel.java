package com.burmamall.burmamall.model;

/**
 * Created by sand on 2018/1/31.
 */

public class FacebookUserInfoModel {

    /**
     * id : 529996257381512
     * name : 廖南
     * link : https://www.facebook.com/app_scoped_user_id/529996257381512/
     * gender : male
     * picture : {"data":{"height":50,"is_silhouette":false,"url":"https://scontent.xx.fbcdn.net/v/t1.0-1/p50x50/20799085_459661434414995_472852686883970823_n.jpg?oh=84c2934b816e16e8ad41b8b3028de166&oe=5AEA3985","width":50}}
     * locale : zh_CN
     * updated_time : 2017-08-14T13:54:54+0000
     * timezone : 8
     * age_range : {"min":21}
     * first_name : 南
     * last_name : 廖
     */

    private String id;
    private String name;
    private String link;
    private String gender;
    private PictureBean picture;
    private String locale;
    private String updated_time;
    private int timezone;
    private AgeRangeBean age_range;
    private String first_name;
    private String last_name;

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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public PictureBean getPicture() {
        return picture;
    }

    public void setPicture(PictureBean picture) {
        this.picture = picture;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getUpdated_time() {
        return updated_time;
    }

    public void setUpdated_time(String updated_time) {
        this.updated_time = updated_time;
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public AgeRangeBean getAge_range() {
        return age_range;
    }

    public void setAge_range(AgeRangeBean age_range) {
        this.age_range = age_range;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public String toString() {
        return "FacebookUserInfoModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", gender='" + gender + '\'' +
                ", picture=" + picture.toString() +
                ", locale='" + locale + '\'' +
                ", updated_time='" + updated_time + '\'' +
                ", timezone=" + timezone +
                ", age_range=" + age_range.toString() +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }

    public static class PictureBean {
        @Override
        public String toString() {
            return "PictureBean{" +
                    "data=" + data +
                    '}';
        }

        /**
         * data : {"height":50,"is_silhouette":false,"url":"https://scontent.xx.fbcdn.net/v/t1.0-1/p50x50/20799085_459661434414995_472852686883970823_n.jpg?oh=84c2934b816e16e8ad41b8b3028de166&oe=5AEA3985","width":50}
         */

        private DataBean data;

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public static class DataBean {
            @Override
            public String toString() {
                return "DataBean{" +
                        "height=" + height +
                        ", is_silhouette=" + is_silhouette +
                        ", url='" + url + '\'' +
                        ", width=" + width +
                        '}';
            }

            /**
             * height : 50
             * is_silhouette : false
             * url : https://scontent.xx.fbcdn.net/v/t1.0-1/p50x50/20799085_459661434414995_472852686883970823_n.jpg?oh=84c2934b816e16e8ad41b8b3028de166&oe=5AEA3985
             * width : 50
             */

            private int height;
            private boolean is_silhouette;
            private String url;
            private int width;

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public boolean isIs_silhouette() {
                return is_silhouette;
            }

            public void setIs_silhouette(boolean is_silhouette) {
                this.is_silhouette = is_silhouette;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }
        }
    }

    public static class AgeRangeBean {
        @Override
        public String toString() {
            return "AgeRangeBean{" +
                    "min=" + min +
                    '}';
        }

        /**
         * min : 21
         */

        private int min;

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }
    }
}
