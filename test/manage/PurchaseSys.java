package test.manage;

import base.CInput;
import goods.Clothing;
import goods.Computer;
import goods.Phone;
import purchase.Purchase;
import purchase.ShoppingCart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PurchaseSys {
    //un 与 pw 分别是默认的账户名与密码
    private String un = "admin";
    private String pw = "123456";
    //实例化Purchase购买类，初始化商品数据
    private Purchase purchase = new Purchase();
    private CInput cInput = new CInput();
    //登录判断
    private boolean loginJudge = false;

    //商品类型List列表
    private List<String> goodsNameList = purchase.getTypelist();
    //三种具体商品的信息列表
    private List<Computer> listComputer = (List<Computer>) purchase.getM().get(goodsNameList.get(0));
    private List<Clothing> listClothing = (List<Clothing>) purchase.getM().get(goodsNameList.get(1));
    private List<Phone> listPhone = (List<Phone>) purchase.getM().get(goodsNameList.get(2));
    //购物车购买记录列表
    private List<ShoppingCart> listShoppingCart = new ArrayList<>();
    //购物车整理
    private Map<String, ShoppingCart> betterShoppingCartMap = new HashMap<>();
    //余额
    private double money = 0;


    private double sumShoppingCart = 0;


    //登录
    public void login() {
        boolean loginJudge = false;
        int count = 1;
        String userName = null;
        String password = null;
        while (!loginJudge) {
            purchase.show("开始第 " + count + " 次登录,请输入用户名。\n 输入'quit'可直接退出系统 ");
            count++;
            userName = cInput.readString();
            //对参数userName进行非空判断
            if (userName == null || userName.equals("")) {
                purchase.show("用户名不可为空，请重新输入");
                //结束本次循环
                continue;
            } else {
                //用户名输入通过，开始输入密码
                purchase.show("请输入密码");
                password = cInput.readString();
                //对参数password进行非空判断
                if (password == null || password.equals("")) {
                    purchase.show("密码不可为空，请重新输入");
                    //结束本次循环
                    continue;
                } else {
                    if (userName.equals(un) && password.equals(pw)) {
                        purchase.show("用户登录成功");
                        loginJudge = true;
                    } else {
                        purchase.show("用户登录失败，请检查用户名与密码重新进行登录");
                        continue;
                    }
                }
            }
        }
    }


    //获得商品列表
    public void getGoodsTypelist() {

        //index是最外层商品类型编号
        int goodType = -1;
        //minIndex是最外层商品类型编号
        int typeIndex = -1;
        //count商品购买数量
        int count = 0;
        //存到购物车类里面
        ShoppingCart shoppingCart = new ShoppingCart();

        purchase.show("\n开始展示商品列表 \n序号 | 商品类型\"");
        for (int i = 0; i < goodsNameList.size(); ++i) {
            System.out.println(i + "   | " + goodsNameList.get(i));
        }
        purchase.show("\n请输入想查询的商品的序号\n");
        //获取用户的输入的商品类别序号
        goodType = cInput.readInt();
        //防手贱
        while (goodType < 0 || goodType >= goodsNameList.size()) {
            purchase.show("亲，请重新输入合理的数据哦");
            goodType = cInput.readInt();
        }
        purchase.show("开始展示 " + goodsNameList.get(goodType) + " 类型的产品数据\n");

        if (goodType == 0) {
            //展示商品详细信息列表
            for (int i = 0; i < listComputer.size(); ++i) {
                System.out.println("商品编号: " + i + "  " + listComputer.get(i).toString() + "\n");
            }
            purchase.show("请输入想购买的商品编号");
            //防手贱
            typeIndex = cInput.readInt();
            while (typeIndex < 0 || typeIndex >= listComputer.size()) {
                purchase.show("亲，请重新输入合理的数据哦");
                typeIndex = cInput.readInt();
            }
            //获得了具体商品信息了，开始输入数量
            purchase.show("请输入想购买的数量");
            count = CInput.readInt();
            //存到购物车类里面
            shoppingCart.setGoodType(0);
            shoppingCart.setComputer(listComputer.get(typeIndex));
            shoppingCart.setCount(count);
            listShoppingCart.add(shoppingCart);
        } else if (goodType == 1) {
            //展示商品详细信息列表
            for (int i = 0; i < listClothing.size(); ++i) {
                System.out.println("商品编号: " + i + "  " + listClothing.get(i).toString() + "\n");
            }
            purchase.show("请输入想购买的商品编号");
            //防手贱
            typeIndex = cInput.readInt();
            while (typeIndex < 0 || typeIndex >= listClothing.size()) {
                purchase.show("亲，请重新输入合理的数据哦");
                typeIndex = cInput.readInt();
            }
            //获得了具体商品信息了，开始输入数量
            purchase.show("请输入想购买的数量");
            count = CInput.readInt();
            //存到购物车类里面
            shoppingCart.setGoodType(1);
            shoppingCart.setClothing(listClothing.get(typeIndex));
            shoppingCart.setCount(count);
            listShoppingCart.add(shoppingCart);
        } else if (goodType == 2) {
            //展示商品详细信息列表
            for (int i = 0; i < listPhone.size(); ++i) {
                System.out.println("商品编号: " + i + "  " + listPhone.get(i).toString() + "\n");
            }
            purchase.show("请输入想购买的商品编号");
            //防手贱
            typeIndex = cInput.readInt();
            while (typeIndex < 0 || typeIndex >= listPhone.size()) {
                purchase.show("亲，请重新输入合理的数据哦");
                typeIndex = cInput.readInt();
            }
            //获得了具体商品信息了，开始输入数量
            purchase.show("请输入想购买的数量");
            count = CInput.readInt();
            //存到购物车类里面
            shoppingCart.setGoodType(2);
            shoppingCart.setPhone(listPhone.get(typeIndex));
            shoppingCart.setCount(count);
            listShoppingCart.add(shoppingCart);
        }
    }


    //查看购物车购买信息
    public void getBuyInfo() {


        sumShoppingCart = 0;
        purchase.show("开始展示已加入购物车的商品信息");
        System.out.println("名称  |  价格  |  数量  ");
        for (ShoppingCart s : listShoppingCart) {
            if (s.getGoodType() == 0) {
                System.out.println(s.getComputer().getName() + "  | " + s.getComputer().getPrice() + "  | " + s.getCount());
                sumShoppingCart += s.getCount() * s.getComputer().getPrice();

            } else if (s.getGoodType() == 1) {
                System.out.println(s.getClothing().getName() + "  | " + s.getClothing().getPrice() + "  | " + s.getCount());
                sumShoppingCart += s.getCount() * s.getClothing().getPrice();

            } else {
                System.out.println(s.getPhone().getName() + "  | " + s.getPhone().getPrice() + "  | " + s.getCount() + "\n");
                sumShoppingCart += s.getCount() * s.getPhone().getPrice();

            }
        }
        purchase.show("购物车商品总价为：" + sumShoppingCart + "\n\n");

    }


    //购物车整理
    public Map<String, Object> doWithPurchase() {

        sumShoppingCart = 0;

        for (ShoppingCart s : listShoppingCart) {
            if (s.getGoodType() == 0) {
                //首先获取商品，判断属性
                Computer computer = s.getComputer();
                String newName = computer.getName() + "-" + computer.getSupply().getSupplier();
                if (betterShoppingCartMap.get(newName) == null) {
                    //构建初始数据
                    betterShoppingCartMap.put(newName, s);
                } else {
                    int newCount = s.getCount() + betterShoppingCartMap.get(newName).getCount();
                    s.setCount(newCount);
                    betterShoppingCartMap.put(newName, s);
                }

                sumShoppingCart += s.getCount() * s.getComputer().getPrice();

            } else if (s.getGoodType() == 1) {
                //首先获取商品，判断属性
                Clothing clothing = s.getClothing();
                String newName = clothing.getName() + "-" + clothing.getSupply().getSupplier();
                if (betterShoppingCartMap.get(newName) == null) {
                    //构建初始数据
                    betterShoppingCartMap.put(newName, s);
                } else {
                    int newCount = s.getCount() + betterShoppingCartMap.get(newName).getCount();
                    s.setCount(newCount);
                    betterShoppingCartMap.put(newName, s);
                }
                sumShoppingCart += s.getCount() * s.getClothing().getPrice();

            } else if (s.getGoodType() == 2) {
                //首先获取商品，判断属性
                Phone phone = s.getPhone();
                String newName = phone.getName() + "-" + phone.getSupply().getSupplier();
                if (betterShoppingCartMap.get(newName) == null) {
                    //构建初始数据
                    betterShoppingCartMap.put(newName, s);
                } else {
                    int newCount = s.getCount() + betterShoppingCartMap.get(newName).getCount();
                    s.setCount(newCount);
                    betterShoppingCartMap.put(newName, s);
                }
                sumShoppingCart += s.getCount() * s.getPhone().getPrice();
            } else {
                //不做任何操作
            }
        }

        //开始展示整理后的商品信息
        System.out.println("商品名称  |  价格  |  数量  |  供应商");
        for (Map.Entry<String, ShoppingCart> entry : betterShoppingCartMap.entrySet()) {
            if (entry.getValue().getGoodType() == 0) {
                Computer c = entry.getValue().getComputer();
                System.out.println(c.getName() + "  | " + c.getPrice() + "  | " + entry.getValue().getCount() + "  | " + c.getSupply().getSupplier());
            } else if (entry.getValue().getGoodType() == 1) {
                Clothing c = entry.getValue().getClothing();
                System.out.println(c.getName() + "  | " + c.getPrice() + "  | " + entry.getValue().getCount() + "  | " + c.getSupply().getSupplier());
            } else {
                Phone p = entry.getValue().getPhone();
                System.out.println(p.getName() + "  | " + p.getPrice() + "  | " + entry.getValue().getCount() + "  | " + p.getSupply().getSupplier());
            }

        }
        purchase.show("购物车商品总价为：" + sumShoppingCart + "\n\n");


        return null;

    }


    //购物车结算
    public void savePurchase(String str) {
        //判断输入是否合法在测试类 TestPurchase里面检验了。
        //readingDouble方法有问题，弃用，用Integer接Double，人才
        double inputMoney = 0;
        //字符串str转double

        inputMoney = Double.parseDouble(str);
        while (inputMoney == 0) {
            System.out.println("亲，您的输入金额为0或者输入金额不合法，请检查并重新输入金额");
            inputMoney = cInput.readDouble(str);
        }
        System.out.println("==========");
        money += inputMoney;
        System.out.println("当前购物车的总金额为：" + sumShoppingCart + " " + "您的账户总金额为：" + money);
        if (money > sumShoppingCart) {
            System.out.println("支付成功，您的余额为" + (money - sumShoppingCart));
            this.money = this.money - sumShoppingCart;
            //清空购物车
            listShoppingCart=new ArrayList<>();
            betterShoppingCartMap=new HashMap<>();

        } else {
            System.out.println("支付失败，您的余额不足,目前总余额为：" + money);
        }

    }


    public void show() {
        purchase.show();
    }


    public void show(String s) {
        purchase.show(s);
    }

    public Purchase getPurchase() {
        return this.purchase;
    }

    public double getMoney() {
        return this.money;
    }

}
