package com.yusys.jvm;

/**
 * 类加载方式：
 * 1、显示加载
 * Created by huyang on 2019/10/18.
 */
public class TestClassLoader01{

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = TestClassLoader01.class.getClassLoader();
        loader.loadClass("com.yusys.jvm.Student");
//        Class.forName("com.yusys.jvm.Student");

        // 加载类时是否执行静态代码块
        Class.forName("com.yusys.jvm.Student",true,loader);
    }
}
 class Student {
    static {
        System.out.println("Student");
    }
}
