package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 项目名：    leetcode
 * 包名：      threadpool
 * 文件名：    FixedThreadPoolTest
 * 创建时间:   2020-03-30-16:50
 *
 * @author zhangsiqi
 * 描述：演示newFixedThreadPool
 */

public class FixedThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 1000; i++) {
            executorService.execute(new Task());
        }
    }

}

class Task implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
