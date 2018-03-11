package com.burmamall.burmamall.model;

import java.util.List;

/**
 * Created by sand on 2018/2/4.
 */

public class StoreModel {

    /**
     * seller : {"id":"1","seller_name":"admin","logo":"upload/2018/02/02/20180202194805712.png"}
     * seller_goods : [{"id":"1","name":"飞利浦（PHILIPS）32PHF3056/T3 32英寸 高清LED液晶电视（黑色）","sell_price":"1299.00","market_price":"1599.00","img":"upload/2015/06/16/554d82c3N5bf6ede3.jpg"},{"id":"18","name":"绿色森林（GREEN FOREST）专柜品牌男士短袖丝光棉衬衫男 1506# L码","sell_price":"168.00","market_price":"699.00","img":"upload/2015/06/16/5572aecbN397793f1.jpg"},{"id":"44","name":"英伦复古机车包 欧美时尚女包 真皮女包 单肩斜跨油蜡皮包","sell_price":"205.00","market_price":"205.00","img":"upload/2015/06/16/20150616233303626.jpg"},{"id":"48","name":"欧美时尚大牌明星同款铂金包经典爆款蜥蜴纹碎花头层牛皮真皮女包","sell_price":"398.00","market_price":"398.00","img":"upload/2015/06/16/20150616233307383.jpg"},{"id":"55","name":"新款韩版时尚头层牛皮真皮女包，双肩背包","sell_price":"255.00","market_price":"255.00","img":"upload/2015/06/16/20150616233310871.jpg"},{"id":"216","name":"张裕特选级解百纳干红葡萄酒750ml*6","sell_price":"558.00","market_price":"708.00","img":"upload/2016/01/22/5549e37bN8ba1918b.jpg"},{"id":"217","name":"法国进口红酒 拉菲罗氏传奇波尔多干红葡萄酒 整箱装750ml*6瓶","sell_price":"468.00","market_price":"588.00","img":"upload/2016/01/22/564e7b7aNa247e73f.jpg"},{"id":"218","name":"法国进口红酒 塞莱斯城堡干红葡萄酒 整箱装 750ml*6瓶","sell_price":"238.00","market_price":"3998.00","img":"upload/2016/01/22/568cccfdN6f817ec5.jpg"}]
     */

    private SellerBean seller;
    private List<FlashDealsModel> seller_goods;

    public SellerBean getSeller() {
        return seller;
    }

    public void setSeller(SellerBean seller) {
        this.seller = seller;
    }

    public List<FlashDealsModel> getSeller_goods() {
        return seller_goods;
    }

    public void setSeller_goods(List<FlashDealsModel> seller_goods) {
        this.seller_goods = seller_goods;
    }

    public static class SellerBean {
        /**
         * id : 1
         * seller_name : admin
         * logo : upload/2018/02/02/20180202194805712.png
         */

        private String id;
        private String seller_name;
        private String logo;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSeller_name() {
            return seller_name;
        }

        public void setSeller_name(String seller_name) {
            this.seller_name = seller_name;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }
    }

    public static class SellerGoodsBean {
        /**
         * id : 1
         * name : 飞利浦（PHILIPS）32PHF3056/T3 32英寸 高清LED液晶电视（黑色）
         * sell_price : 1299.00
         * market_price : 1599.00
         * img : upload/2015/06/16/554d82c3N5bf6ede3.jpg
         */

        private String id;
        private String name;
        private String sell_price;
        private String market_price;
        private String img;

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

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }
    }
}
