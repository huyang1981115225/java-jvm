package com.yusys.jvm;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by huyang on 2019/10/18.
 */
public class MyClassLoader02 extends URLClassLoader {
    public MyClassLoader02(URL[] urls) {
        super(urls,null);
    }
}
