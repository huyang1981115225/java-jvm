package com.yusys.jvm;

/**
 * 类加载方式：
 * 2、隐式加载
 * Created by huyang on 2019/10/18.
 */
public class TestClassLoader02 {

    public static void main(String[] args) {
//        System.out.println(Person.age);
//        Person.doPrint();
//        new Person();
        new Tom();
    }
}

class Person {
    static int age = 18;

    static {
        System.out.println("Person.static");
    }

    static void doPrint() {
        System.out.println("print class info");
    }
}

class Tom extends Person{
    static {
        System.out.println("Tom.static");
    }
}
