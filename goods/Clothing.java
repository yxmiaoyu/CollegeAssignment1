package goods;

import base.Goods;
import base.Supply;

public class Clothing extends Goods {
    //货物名称：衣服
    public static final String CLOTHING = "衣服";
    //衣服的属性
    public String name, sex, size, colour;

    //有参构造函数，实例化时候就配置属性
    public Clothing(String name, double price, Supply supply, String sex, String size, String colour) {
        super(CLOTHING, supply);
        this.name = name;
        super.price = price;
        this.sex = sex;
        this.size = size;
        this.colour = colour;
    }

    //信息打印
    public String toString() {
        return super.toString() + "\n产品名称：" + this.name + " 价格：" + this.price + "\n产品信息：\n" + "类型:" + this.sex + "，颜色:"
                + this.colour + "，型号:" + this.size + super.supplydesc();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
