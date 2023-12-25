package purchase;


import goods.Clothing;
import goods.Computer;
import goods.Phone;

public class ShoppingCart {

    //商品数量
    private int count;
    //电脑 衣服 手机
    private int goodType;
    private Clothing clothing;
    private Computer computer;
    private Phone phone;

    public int getGoodType() {
        return goodType;
    }

    public void setGoodType(int goodType) {
        this.goodType = goodType;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    public Clothing getClothing() {
        return clothing;
    }

    public void setClothing(Clothing clothing) {
        this.clothing = clothing;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "count=" + count +
                ", goodType=" + goodType +
                ", clothing=" + clothing +
                ", computer=" + computer +
                ", phone=" + phone +
                '}';
    }
}
