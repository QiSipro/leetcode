package singleton;

/**
 * 项目名：    leetcode
 * 包名：      singleton
 * 文件名：    Singleton1
 * 创建时间:   2020-03-28-22:03
 *
 * @author zhangsiqi
 * 描述：懒汉式（线程不安全）（不可用）
 */

public class Singleton3 {

    private static Singleton3 INSTANCE;


    private Singleton3() {

    }

    public static Singleton3 getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton3();
        }
        return INSTANCE;
    }
}
