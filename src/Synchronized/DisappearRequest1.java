package Synchronized;

/**
 * 项目名：    leetcode
 * 包名：      Synchronized
 * 文件名：    DisappearRequest1
 * 创建时间:   2020-02-14-21:14
 *
 * @author zhangsiqi
 * 描述：      消失的请求数
 */

public class DisappearRequest1 implements Runnable {

    static DisappearRequest1 instance = new DisappearRequest1();

    static volatile int i = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);

        Integer t3 = 10;
        t1.start();
        t2.start();
        t2.join();
        t1.join();
        System.out.println(i);
    }

    @Override
    public void run() {
        for (int j = 0; j < 100000; j++) {
            i++;
        }
    }
}
