package singleton;

/**
 * 项目名：    leetcode
 * 包名：      singleton
 * 文件名：    Singleton1
 * 创建时间:   2020-03-28-22:03
 *
 * @author zhangsiqi
 * 描述：双重检查（推荐免试使用）
 * 优点：线程安全；延迟加载；效率较高。
 * 缺点：
 */

public class Singleton6 {

    private volatile static Singleton6 INSTANCE;


    private Singleton6() {

    }

    public static Singleton6 getINSTANCE() {
        if (INSTANCE == null) {
            synchronized (Singleton6.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton6();
                }
            }
        }
        return INSTANCE;
    }
}
