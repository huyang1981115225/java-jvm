package com.yusys.jvm;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

/**
 * Created by huyang on 2019/10/18.
 */
public class TestMyClassLoader02 {
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        File file = new File("E:\\");

        // File to URI
        URI uri = file.toURI();
        URL[] urls = {uri.toURL()};
        ClassLoader classLoader = new MyClassLoader02(urls);
        Class<?> cls = classLoader.loadClass("jvm_myClassLoader.Search");
        Object obj = cls.newInstance();
        System.out.println(classLoader);
        System.out.println(obj);
    }
}
