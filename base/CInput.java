package base;

import java.util.Scanner;

public class CInput {
    public static Scanner sc = new Scanner(System.in);

    //打印参数 s
    public static String readString(String s) {
        System.out.print(s);
        return readString();
    }

    //从控制台获取参数 s
    //如果 s=quit表示推出系统
    public static String readString() {
        String temp = sc.next();
        if (temp.equalsIgnoreCase("quit")) {
            System.out.println("谢谢使用，再见~");
            System.exit(0);
        }
        return temp;
    }

    public static int readInt(String s) {
        String a = readString(s);
        try {
            Integer.parseInt(a);
            return Integer.parseInt(a);
        } catch (NumberFormatException ex) {
            return 0;
        }
    }

    public static int readInt() {
        String a = readString();
        try {
            Integer.parseInt(a);
            return Integer.parseInt(a);
        } catch (NumberFormatException ex) {
            return 0;
        }
    }

    public static double readDouble(String s) {
        String a = readString(s);
        try {
            Double.parseDouble(a);
            return Double.parseDouble(a);
        } catch (NumberFormatException ex) {
            return 0;
        }
    }

    public static int readDouble() {
        String a = readString();
        try {
            Integer.parseInt(a);
            return Integer.parseInt(a);
        } catch (NumberFormatException ex) {
            return 0;
        }
    }

}
