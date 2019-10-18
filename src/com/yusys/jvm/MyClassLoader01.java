package com.yusys.jvm;

import java.io.*;

/**
 * Created by huyang on 2019/10/18.
 */
public class MyClassLoader01 extends ClassLoader {

    private String baseDir;

    public MyClassLoader01(String baseDir) {
        this.baseDir = baseDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = loadClassBytes(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(name, classData, 0, classData.length);
        }
    }

    /**
     * 自己定义
     *
     * @return
     */
    private byte[] loadClassBytes(String className) {

        String fileName = baseDir + className.replace('.', File.separatorChar) + ".class";
        System.out.println("fileName: " + fileName);
        InputStream ins = null;
        try {
            ins = new FileInputStream(fileName);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];
            int length = 0;
            while ((length = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, length);
            }
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (ins != null) {
                try {
                    ins.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
