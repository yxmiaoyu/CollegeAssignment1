package goods;

import base.Goods;
import base.Supply;

public class Computer extends Goods {
    public static final String COMPUTER = "电脑";
    public String name, cpu, ram, hard_disk, colour;

    public Computer(String name, double price, Supply supply, String cpu, String ram, String hard_disk,
                    String colour) {
        super(COMPUTER, supply);
        this.name = name;
        super.price = price;
        this.cpu = cpu;
        this.ram = ram;
        this.hard_disk = hard_disk;
        this.colour = colour;
    }


    public String toString() {
        return super.toString()
                + "\n产品名称：" + this.name
                + " 价格：" + this.price
                + "\n产品信息：\n" + "CPU:"
                + this.cpu + "，内存:"
                + this.ram + "，硬盘:" + this.hard_disk
                + "，颜色:" + this.colour
                + super.supplydesc();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getHard_disk() {
        return hard_disk;
    }

    public void setHard_disk(String hard_disk) {
        this.hard_disk = hard_disk;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }


}
