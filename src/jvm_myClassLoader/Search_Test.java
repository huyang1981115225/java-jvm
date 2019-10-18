package jvm_myClassLoader;

/**
 * Created by huyang on 2019/10/18.
 */
public class Search_Test {
    static {
        System.out.println("Search_Test static");
    }

    public Search_Test(){
        System.out.println("Search_Test Constructor");
    }
}
