package test;

import base.CInput;
import test.manage.PurchaseSys;

public class TestPurchase {

    public static void main(String[] args) {
        // 1.实例化PurchaseSys购买系统类,初始化系统数据
        PurchaseSys sys = new PurchaseSys();
        // 初始化CInput输入工具类
        CInput cInput = new CInput();


        // 2.开始登录
//        sys.login();

        // 3. 接收命令，开始处理购物操作
        sys.show("请输入您的操作编号：\n" +
                "1 :查看商品列表并购买商品\n" +
                "2 :查看购物车购买记录\n" +
                "3 :查看购物车整理后的记录\n" +
                "4 :购物车结算\n" +
                "5 :退出系统\n\n");
        String orderString = cInput.readString();

        int orderNum = Integer.parseInt(orderString.toString());
        while (orderNum != 5) {
            //查看商品列表并购买商品
            if (orderNum == 1) {
                //展示商品列表
                sys.getGoodsTypelist();
                sys.show("请输入您的操作编号：\n" +
                        "1 :查看商品列表并购买商品\n" +
                        "2 :查看购物车购买记录\n" +
                        "3 :查看购物车整理后的记录\n" +
                        "4 :购物车结算\n" +
                        "5 :退出系统\n\n");
                //查看购物车购买记录
            } else if (orderNum == 2) {
                sys.getBuyInfo();
                sys.show("请输入您的操作编号：\n" +
                        "1 :查看商品列表并购买商品\n" +
                        "2 :查看购物车购买记录\n" +
                        "3 :查看购物车整理后的记录\n" +
                        "4 :购物车结算\n" +
                        "5 :退出系统\n\n");
                //查看整理后的购物车
            } else if (orderNum == 3) {
                sys.doWithPurchase();
                sys.show("请输入您的操作编号：\n" +
                        "1 :查看商品列表并购买商品\n" +
                        "2 :查看购物车购买记录\n" +
                        "3 :查看购物车整理后的记录\n" +
                        "4 :购物车结算\n" +
                        "5 :退出系统\n\n");
                //
            } else if (orderNum == 4) {
                System.out.println("您的账户目余额为："+sys.getMoney()+"请输入您本次充值金额");
                String s=cInput.readString();
                while(s==null || s.equals("")){
                    System.out.println("您的输入金额不合法，请重新输入");
                    s=cInput.readString();
                }
                sys.savePurchase(s);
                sys.show("请输入您的操作编号：\n" +
                        "1 :查看商品列表并购买商品\n" +
                        "2 :查看购物车购买记录\n" +
                        "3 :查看购物车整理后的记录\n" +
                        "4 :购物车结算\n" +
                        "5 :退出系统\n\n");


            } else if (orderNum == 5) {
                sys.show("欢迎使用本系统，用户已退出\n");
                break;
            } else {
                //退出系统
                //防手贱
                sys.show("操作标号输入错误，请重新输入\n");
            }

            orderNum = Integer.parseInt(cInput.readString().toString());
        }


//        //检查商品列表与购物车
//        sys.test();


        //初始化Purchase类时候会通过构造方法初始化m中的基础数据。
    }


    //采购人员成功登录系统后，先搜索商品，在搜索信息中，选中需要购买的商品。
    //将购买商品数量和总价格显示出来。
    //可以通过系统留言，比如：通过控制台输入想购买的商品的信息。留言输入后可以显示出来。


    //以个人为单位完成系统，采购商品可以自己确定，例如采购电器、鲜花、文具等等。
    //对商品的属性进行设计和定义（商品属性至少包含：商品名称，商品分类，商品单价，商品供应商）。

}
