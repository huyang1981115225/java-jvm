package com.yusys.jvm;

/**
 * Created by huyang on 2019/10/18.
 */
public class TestMyClassLoader01 {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String baseDir = "E:\\";
        MyClassLoader01 classLoader = new MyClassLoader01(baseDir);

        //此类不要和当前类放在相同的目录结构中
        String pkgClass = "jvm_myClassLoader.Search";
        Class<?> testClass = classLoader.loadClass(pkgClass);
        Object obj = testClass.newInstance();
        System.out.println(obj.getClass());
        /**
         *  TODO 注意：如果jvm_myClassLoader包下有Search类，则会使用AppClassLoader
         *  TODO 可以把Search_Test改成Search进行测试
         */
        System.out.println(obj.getClass().getClassLoader());// com.yusys.jvm.MyClassLoader01@677327b6
    }
}
