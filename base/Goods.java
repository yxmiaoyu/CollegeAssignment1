package base;

public class Goods {

    //商品种类
    public String goodstype;
    //商品价格
    public double price;
    //供应商信息
    public Supply supply;
    //有参构造函数

    public Goods(String goodstype, Supply supply) {
        this.goodstype = goodstype;
        this.supply = supply;
    }


    public String getGoodstype() {
        return goodstype;
    }

    public void setGoodstype(String goodstype) {
        this.goodstype = goodstype;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Supply getSupply() {
        return supply;
    }

    public void setSupply(Supply supply) {
        this.supply = supply;
    }

    // 商品基本信息
    public String toString() {
        return "商品种类：" + this.goodstype;
    }

    // 供应商信息
    public String supplydesc() {
        supply = new Supply(supply.supplier, supply.address, supply.telephone);
        return supply.toString();
    }

}
