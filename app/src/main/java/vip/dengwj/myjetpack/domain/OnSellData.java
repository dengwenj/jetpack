package vip.dengwj.myjetpack.domain;

import java.util.List;

public class OnSellData {

    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        private String cover;
        private String source;
        private String title;
        private double couponAmount;
        private String zkFinalPrice;
        private String couponShareUrl;
        private int couponTotalCount;
        private int couponRemainCount;
        private int sellCount;
        private String justPrice;

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public double getCouponAmount() {
            return couponAmount;
        }

        public void setCouponAmount(double couponAmount) {
            this.couponAmount = couponAmount;
        }

        public String getZkFinalPrice() {
            return zkFinalPrice;
        }

        public void setZkFinalPrice(String zkFinalPrice) {
            this.zkFinalPrice = zkFinalPrice;
        }

        public String getCouponShareUrl() {
            return couponShareUrl;
        }

        public void setCouponShareUrl(String couponShareUrl) {
            this.couponShareUrl = couponShareUrl;
        }

        public int getCouponTotalCount() {
            return couponTotalCount;
        }

        public void setCouponTotalCount(int couponTotalCount) {
            this.couponTotalCount = couponTotalCount;
        }

        public int getCouponRemainCount() {
            return couponRemainCount;
        }

        public void setCouponRemainCount(int couponRemainCount) {
            this.couponRemainCount = couponRemainCount;
        }

        public int getSellCount() {
            return sellCount;
        }

        public void setSellCount(int sellCount) {
            this.sellCount = sellCount;
        }

        public String getJustPrice() {
            return justPrice;
        }

        public void setJustPrice(String justPrice) {
            this.justPrice = justPrice;
        }

        @Override
        public String toString() {
            return "ListBean{" +
                    "cover='" + cover + '\'' +
                    ", source='" + source + '\'' +
                    ", title='" + title + '\'' +
                    ", couponAmount=" + couponAmount +
                    ", zkFinalPrice='" + zkFinalPrice + '\'' +
                    ", couponShareUrl='" + couponShareUrl + '\'' +
                    ", couponTotalCount=" + couponTotalCount +
                    ", couponRemainCount=" + couponRemainCount +
                    ", sellCount=" + sellCount +
                    ", justPrice='" + justPrice + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "OnSellData{" +
                "list=" + list +
                '}';
    }
}
