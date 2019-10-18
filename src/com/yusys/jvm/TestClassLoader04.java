package com.yusys.jvm;

import java.util.ArrayList;

/**
 * Created by huyang on 2019/10/18.
 */
public class TestClassLoader04 {

    public static void main(String[] args) {
//        doMethod01();
//        doMethod02();
        doMethod03();
    }

    public static void doMethod01(){
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        System.out.println(loader);// sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(loader.getParent());// sun.misc.Launcher$ExtClassLoader@1540e19d
        System.out.println(loader.getParent().getParent());// null
    }
    public static void doMethod02(){
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println(loader);// sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(loader.getParent());// sun.misc.Launcher$ExtClassLoader@1540e19d
        System.out.println(loader.getParent().getParent());// null
    }
    public static void doMethod03(){
        // sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println("ClassLoader of this class: "+TestClassLoader04.class.getClassLoader());

        // null
        System.out.println("ClassLoader of ArrayList: "+ArrayList.class.getClassLoader());
    }
}
