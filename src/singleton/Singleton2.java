package singleton;

/**
 * 项目名：    leetcode
 * 包名：      singleton
 * 文件名：    Singleton1
 * 创建时间:   2020-03-28-22:03
 *
 * @author zhangsiqi
 * 描述：饿汉式（静态代码块） （可用）
 */

public class Singleton2 {

    private final static Singleton2 INSTANCE;

    static {
        INSTANCE = new Singleton2();
    }

    private Singleton2() {

    }

    public static Singleton2 getINSTANCE() {
        return INSTANCE;
    }
}
