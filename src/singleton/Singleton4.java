package singleton;

/**
 * 项目名：    leetcode
 * 包名：      singleton
 * 文件名：    Singleton1
 * 创建时间:   2020-03-28-22:03
 *
 * @author zhangsiqi
 * 描述：懒汉式（线程安全）（不推荐）
 */

public class Singleton4 {

    private static Singleton4 INSTANCE;


    private Singleton4() {

    }

    public synchronized static Singleton4 getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton4();
        }
        return INSTANCE;
    }
}
