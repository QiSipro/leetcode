package Synchronized;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 项目名：    leetcode
 * 包名：      Synchronized
 * 文件名：    MultiThreadsError
 * 创建时间:   2020-02-19-15:03
 *
 * @author zhangsiqi
 * 描述：
 */

public class MultiThreadsError implements Runnable {
    static MultiThreadsError instance = new MultiThreadsError();
    int index = 0;
    final boolean[] marked = new boolean[100000];
    static AtomicInteger rightCount = new AtomicInteger();
    static AtomicInteger wrongCount = new AtomicInteger();

    /**
     * 阻挡两个线程
     */
    static volatile CyclicBarrier cyclic1 = new CyclicBarrier(2);
    static volatile CyclicBarrier cyclic2 = new CyclicBarrier(2);

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("表面结果是：" + instance.index);
        System.out.println("错误次数是：" + wrongCount.get());
        System.out.println("真实结果是：" + rightCount.get());
    }

    @Override
    public void run() {
        // 使用while就算出错了也可能会在下次循环加回来。表面看上去没有出错
//        while (index < 10000) {
//            index++;
//        }

//        for (int i = 0; i < 10000; i++) {
//            index++;
//            rightCount.incrementAndGet();
//            // 加完之后立即判断, 如果这一位已经被另一线程加过，就表示出错
//            // 如果两个线程已经发生冲突，但是对于第一次判断都为false，
//            // 且无线程将index置为true就会出现计数少了的情况
//            if (marked[index]) {
//                System.out.println("发生错误: " + instance.index);
//                wrongCount.incrementAndGet();
//            }
//            marked[index] = true;
//        }

//        for (int i = 0; i < 10000; i++) {
//            index++;
//            rightCount.incrementAndGet();
//            synchronized (instance) {
//                // 假设index一开始为0，第一次都到synchronized拿锁
//                // 假设线程一拿到了锁，执行marked[1]=true,然后释放锁
//                // 这时线程二拿到锁，准备判断if，这时切换会线程一，执行完index++，
//                // index变为2，线程2就会判断marked[2]=false不会计数
//                // 引入cyclicBarrier，将线程阻塞起来，防止偷跑
//                if (marked[index]) {
//                    System.out.println("发生错误: " + instance.index);
//                    wrongCount.incrementAndGet();
//                }
//                marked[index] = true;
//            }
//        }

        for (int i = 0; i < 10000; i++) {
            // 如果第一步两个线程就冲突也能记录下来
            marked[0] = true;
            try {
                // 进行拦截，防止其中一个线程偷跑
                cyclic2.reset();
                cyclic1.await();

                index++;
                rightCount.incrementAndGet();
                // 再此等待一起枪锁
                cyclic1.reset();
                cyclic2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            // synchronized代码块中如果有变量修改，在退出时其他线程能感知到
            synchronized (instance) {
                // 如果没有发生错误，一次前进两步，则会false true交替
                // 没有发生错误，假设从0开始，线程一判断marked[2]=false，然后将marked[2]=true;
                // 线程一释放monitor，线程二获得锁，判断marked[2]=true, 但是当前并没有发生错误
                // 修改判断条件，如果前一个已经为true，然而下一次发生错误只走了一步，
                // 就会出出现两个true相连的现象
                if (marked[index] && marked[index - 1]) {
                    System.out.println("发生错误: " + instance.index);
                    wrongCount.incrementAndGet();
                }
                marked[index] = true;
            }
        }
    }
}
