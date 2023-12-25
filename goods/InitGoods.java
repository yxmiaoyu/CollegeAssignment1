package goods;

import base.Supply;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InitGoods {
    public static final String TYPENAME = "typename";

    public static Map init() {
        //总数据
        Map m = new HashMap();
        //类型数据
        List typelist = new ArrayList();
        //------------------------------------

        // 初始化computer数据
        List computerlist = new ArrayList();
        Supply computers1 = new Supply("联想天晴东方专卖店", "中国北京市", "010-87654321");
        Supply computers2 = new Supply("hp兴荣和专卖店", "中国辽宁大连市", "0411-81669801");
        Computer computer11 = new Computer("Lenovo/联想 YOGA710 -14ISK", 5699.00, computers1, "英特尔 酷睿 i5-7200U", "4G",
                "固态256G", "银色");
        Computer computer12 = new Computer("Lenovo/联想 YOGA 5 Pro yoga910", 9999.00, computers1, "英特尔 酷睿 i5-7200U", "8G",
                "固态512G", "酒红色");
        Computer computer21 = new Computer("HP/惠普 暗影精灵Ⅱ Pro", 5399.00, computers2, " 英特尔 酷睿 i5-7300HQ", "8G", "机械1TB",
                "黑色");
        Computer computer22 = new Computer("HP/惠普 Spectre Pro X360", 9399.00, computers2, "英特尔 酷睿 i5-7200U", "8G",
                "固态256G", "月光银");
        computerlist.add(computer11);
        computerlist.add(computer12);
        computerlist.add(computer21);
        computerlist.add(computer22);
        typelist.add(Computer.COMPUTER);
        //"电脑" - List<Computer>
        m.put(Computer.COMPUTER, computerlist);

        //-------------------------------------------------------------

        // 初始化衣服数据
        List clothinglist = new ArrayList();
        //两种衣服
        Supply clothings1 = new Supply("阿迪达斯东城专卖店", "中国北京市", "010-87654321");
        Supply clothings2 = new Supply("耐克西城专卖店", "中国辽宁大连市", "0411-81669801");
        //两个供应商各有两种衣服
        Clothing clothing11 = new Clothing("2017运动套装", 810, clothings1, "男装", "L-2XL", "黑色、白色");
        Clothing clothing12 = new Clothing("2017情侣套装", 990, clothings1, "情侣装", "（L-3XL & M-2XL）", "橘色、灰色");
        Clothing clothing21 = new Clothing("2017夏春运动休闲圆领短袖T恤", 480, clothings2, "男装", "（M-4XL）", "暗红色、黑色、深蓝色");
        Clothing clothing22 = new Clothing("2017夏季速干体恤半袖上衣运动T恤", 320, clothings2, "女装", "（S-3XL）", "橘色、绿色、玫红色");
        //衣服列表
        clothinglist.add(clothing11);
        clothinglist.add(clothing12);
        clothinglist.add(clothing21);
        clothinglist.add(clothing22);
        //配置类新放到总数居表中
        typelist.add(Clothing.CLOTHING);
        //"衣服" - List<Clothing>
        m.put(Clothing.CLOTHING, clothinglist);


        //-------------------------------------------------------------

        // 初始化手机数据
        List<Phone> phoneList = new ArrayList<>();
        //两种手机
        Supply phoneStore1 = new Supply("小米专卖店", "中国北京市", "010-123456789");
        Supply phoneStore2 = new Supply("华为专卖店", "中国北京市", "0411-987654321");
        //两个供应商各有两种手机
        Phone phoneList11 = new Phone("小米14", 4000, phoneStore1, "6.73寸", "黑色、白色");
        Phone phoneList12 = new Phone("红米K70", 2000, phoneStore1, "6.67寸", "橘色、灰色");
        Phone phoneList21 = new Phone("华为Mate60 Pro ", 7000, phoneStore2, "6.67寸", "暗红色、黑色、深蓝色");
        Phone phoneList22 = new Phone("华为nova11se", 2000, phoneStore2, "6.67寸", "橘色、绿色、玫红色");
        //手机列表
        phoneList.add(phoneList11);
        phoneList.add(phoneList12);
        phoneList.add(phoneList21);
        phoneList.add(phoneList22);
        //配置类新放到总数居表中
        typelist.add(Phone.PHONE);
        m.put(Phone.PHONE, phoneList);

        //-------------------------------------------------------------
        //-------------------------------------------------------------
        //-------------------------------------------------------------
        //-------------------------------------------------------------

        //产品类型数据
        //"typename" - List<String>
        m.put(TYPENAME, typelist);
        return m;
    }

}
