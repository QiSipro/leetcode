package singleton;

/**
 * 项目名：    leetcode
 * 包名：      singleton
 * 文件名：    Singleton1
 * 创建时间:   2020-03-28-22:03
 *
 * @author zhangsiqi
 * 描述：静态内部类方式，可用 懒汉
 */

public class Singleton7 {

    private Singleton7() {

    }

    private static class SingletonInstance {
        private final static Singleton7 INSTANCE = new Singleton7();
    }

    public static Singleton7 getINSTANCE() {
        return SingletonInstance.INSTANCE;
    }
}
