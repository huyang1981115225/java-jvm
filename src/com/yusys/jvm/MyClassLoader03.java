package com.yusys.jvm;

import java.io.*;
import java.util.HashSet;

/**
 * Created by huyang on 2019/10/18.
 */
public class MyClassLoader03 extends ClassLoader {

    private String baseDir;// 需要该类加载器直接加载的类文件的基目录
    private HashSet<String> loadClasses;// 需要有该类加载器直接加载的类名

    public MyClassLoader03(String baseDir, String[] classes) throws IOException {
        // 指定父类加载器为null,打破双亲委派机制
        super(null);
        this.baseDir = baseDir;
        this.loadClasses = new HashSet<String>();
        customerLoadClass(classes);
    }


    // 获取所有文件完整路径及类名，刷入缓存
    public void customerLoadClass(String[] classes) throws IOException {
        for (String classStr : classes) {
            loadDirectory(classStr);
            loadClasses.add(classStr);
        }
    }

    /**
     * 拼接文件路径及文件名
     */
    private void loadDirectory(String name) throws IOException {
        StringBuilder stringBuilder = new StringBuilder(baseDir);
        String className = name.replace('.', File.separatorChar) + ".class";
        stringBuilder.append(File.separator).append(className);
        File classFile = new File(stringBuilder.toString());
        instantiateClass(name, new FileInputStream(classFile), classFile.length());
    }

    // 读取并加载类
    private void instantiateClass(String name, InputStream inputStream, long length) throws IOException {

        byte[] raw = new byte[(int) length];
        inputStream.read(raw);
        inputStream.close();
        // 将字节信息转换为类对象并进行存储
        defineClass(name, raw, 0, raw.length);
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        // 判断是否已经加载(在名字空间中寻找指定的类是否存在)
        Class<?> cls;
        cls = findLoadedClass(name);
        if (!this.loadClasses.contains(name) && cls == null) {
            cls = getSystemClassLoader().loadClass(name);
        }
        if (cls == null) {
            throw new ClassNotFoundException(name);
        }

        if (resolve) {
            resolveClass(cls);
        }
        return cls;
    }
}
