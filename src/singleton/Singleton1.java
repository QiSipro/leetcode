package singleton;

/**
 * 项目名：    leetcode
 * 包名：      singleton
 * 文件名：    Singleton1
 * 创建时间:   2020-03-28-22:03
 *
 * @author zhangsiqi
 * 描述：饿汉式（静态常量） （可用）
 */

public class Singleton1 {
    private final static Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {

    }

    public static Singleton1 getINSTANCE() {
        return INSTANCE;
    }
}
