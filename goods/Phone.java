package goods;

import base.Goods;
import base.Supply;

public class Phone extends Goods {
    //货物名称：手机
    public static final String PHONE = "手机";
    //衣服的属性
    public String name, size, colour;

    //有参构造函数，实例化时候就配置属性
    public Phone(String name, double price, Supply supply, String size, String colour) {
        super(PHONE, supply);
        this.name = name;
        super.price = price;
        this.size = size;
        this.colour = colour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    //信息打印
    @Override
    public String toString() {
        return super.toString() + "\n产品名称：" + this.name + " 价格：" + this.price + "\n产品信息：\n" + "类型:" + this.colour + "，型号:" + this.size + super.supplydesc();
    }
}
