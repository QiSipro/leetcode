package singleton;

/**
 * 项目名：    leetcode
 * 包名：      singleton
 * 文件名：    Singleton1
 * 创建时间:   2020-03-28-22:03
 *
 * @author zhangsiqi
 * 描述：懒汉式（线程不安全）（不推荐）
 */

public class Singleton5 {

    private static Singleton5 INSTANCE;


    private Singleton5() {

    }

    public static Singleton5 getINSTANCE() {
        if (INSTANCE == null) {
            synchronized(Singleton5.class) {
                INSTANCE = new Singleton5();
            }
        }
        return INSTANCE;
    }
}
