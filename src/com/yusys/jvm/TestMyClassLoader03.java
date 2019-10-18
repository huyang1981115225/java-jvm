package com.yusys.jvm;

import java.io.IOException;

/**
 * Created by huyang on 2019/10/18.
 */
public class TestMyClassLoader03 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, InterruptedException {
        MyClassLoader03 loader = new MyClassLoader03("E:\\", new String[]{"jvm_myClassLoader.Search"});
        Class<?> cls = loader.loadClass("jvm_myClassLoader.Search");
        System.out.println(cls.getClassLoader());

        Object search = cls.newInstance();
        System.out.println(search);
        // TODO 模拟热替换
        // 休眠的时候将E:\\jvm_myClassLoader\\Search.java修改重新编译
        Thread.sleep(20000);
        loader = new MyClassLoader03("E:\\", new String[]{"jvm_myClassLoader.Search"});

        cls = loader.loadClass("jvm_myClassLoader.Search");
        System.out.println(cls.getClassLoader());
        search = cls.newInstance();
        System.out.println(search);
    }
}
