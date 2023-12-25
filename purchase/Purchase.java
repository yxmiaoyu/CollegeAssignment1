package purchase;

import base.CInput;
import base.Goods;
import goods.InitGoods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//购买
public class Purchase {

    public Map m = new HashMap();
    //["电脑","衣服"]
    public List typelist = new ArrayList();
    public static final String DESC = "desc";
    public static final String ASC = "asc";
    //购物车
    public List goodslist = new ArrayList();


    public Purchase() {
        //初始化基础数据
        m = InitGoods.init();
        //产品类型数据
        typelist = (List) m.get(InitGoods.TYPENAME);
        show("欢迎使用采购系统\n请按提示操作");
    }

    // 系统欢迎文字
    public void show(String s) {
        int l = s.length();
        if (l > 30)
            l = 30;
        s = "\n" + s + "\n";
        for (int i = 0; i < l * 2 - 1; i++) {
            s = "*" + s + "*";
        }
        System.out.println(s);
    }

    // 分割显示
    // 等价 -------------------------------
    public void show() {
        String s = "";
        for (int i = 0; i < 30; i++) {
            s = "*" + s;
        }
        System.out.println(s);
    }

    //打印商品类型
    public void dowith() {

        System.out.println("商品种类如下：");
        for (int i = 0; i < typelist.size(); i++) {
            //打印编号 与 产品类型
            System.out.println((i + 1) + "、" + typelist.get(i));
            //购物车存放List<Complter> 与 List<Clothing>
            goodslist.add(i, (List) m.get(typelist.get(i)));
        }

        try {
            show();
            //通过Scanner获得输入的数据
            int type = CInput.readInt("请选择商品种类：") - 1;
            selecttype(type);
            display(type);
        } catch (Exception e) {
            System.out.println("\n请输入正确的序号！！\n");
            dowith();
        }
    }

    public void selecttype(int type) {
        if (type > goodslist.size() - 1 || type < 0) {
            System.out.println("\n请输入正确的序号！！\n");
            dowith();
        } else {
            //存放四种电脑或者四种衣服
            List list = new ArrayList();
            list = (List) goodslist.get(type);
            for (int i = 0; i < list.size(); i++) {
                System.out.println("商品购买序号：" + (i + 1));
                System.out.println(list.get(i));
                show();
            }
        }
    }

    public void display(int type) {
        int s = CInput.readInt("请输入商品购买序号:") - 1;
        //s=商品具体的位置+1，type=商品种类
        dowith(s, type);
    }

    //购买方法
    public void dowith(int s, int type) {
        buy((List) goodslist.get(type), s, type);
    }

    //参数1，商品的具体产品集合，存放List<Complter>或者 List<Clothing>，两者中的一个
    //参数2，购买序号
    //参数3，商品种类
    public void buy(List list, int i, int type) {
        int n = CInput.readInt("请输入购买数量:");
        while (n <= 0) {
            System.out.println("\n请输入大于0的整数！\n");
            n = CInput.readInt("请输入购买数量:");
        }
        Goods g = (Goods) list.get(i);
        System.out.println("购买商品详细信息如下：");
        show();
        System.out.println(list.get(i));
        System.out.println("总价格：" + (g.price * n) + ",总数量：" + n);
        System.out.println();

        System.out.println("采购成功，是否继续采购(Y/N)？");
        if (CInput.readString().equalsIgnoreCase("y"))
            selecttype(type);
        else {
            show("谢谢使用！再见~");
            System.exit(0);
        }
    }

    //---------------------------下面是补充的自定义方法---------------------
    public Map getM() {
        return this.m;
    }

    public List getGoodslist() {
        return this.goodslist;
    }

    public List getTypelist() {
        return this.typelist;
    }


}
