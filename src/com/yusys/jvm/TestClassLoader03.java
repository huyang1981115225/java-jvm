package com.yusys.jvm;

/**
 * Created by huyang on 2019/10/18.
 */
public class TestClassLoader03 {

    public static void main(String[] args) {
        System.out.println(B.a);
    }
}

class A{
    public static int a = 10;

    static {
        System.out.println("A.a = "+a);
    }
}

class B extends  A{
    static {
        System.out.println("B");
    }
}
