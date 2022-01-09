package solution;


import java.util.concurrent.locks.StampedLock;

/**
 * 排序
 * 所给数组中只有0，1，2 三个数,数组长度为n
 *
 * @author zhangsiqi
 * @create 2020-01-19-14:31
 */

public class Solution75 {

    public static void main(String[] args) {
        int[] ints = new int[]{2, 2, 1, 2, 1, 1, 1, 0, 0, 2, 1, 0, 2, 1, 2, 2,
                1, 1, 1, 1, 1, 0, 2, 0, 2, 0, 2, 2, 1, 0, 2, 1, 0, 2, 1, 2, 0,
                0, 0, 0, 2, 1, 1, 2, 0, 1, 2, 2, 0, 0, 2, 2, 0, 1, 0, 1, 0, 0,
                1, 1, 1, 0, 0, 2, 2, 2, 1, 0, 0, 2, 1, 0, 1, 0, 2, 2, 1, 2, 1,
                1, 2, 1, 1, 0, 0, 2, 1, 0, 0};
        sortColors(ints);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }

    /**
     * 三路快排 [0,zero] == 0, [zero+1,i-1] == 1, [two,nums.length-1] == 2
     *
     * 另有计数排序，太简单不写
     * @param nums
     */
    static public void sortColors(int[] nums) {
        int zero = -1;
        int two = nums.length;
        int tmp = -1;
        for (int i = 0; i < two; ) {  //保证不超过 2 在的位置
            if (nums[i] == 0) {
                tmp = nums[i];
                nums[i++] = nums[++zero];  // 将zero 的下一个数 放到当前i的位置，
                nums[zero] = tmp;          // 将取到的0 放到zero的位置
            } else if (nums[i] == 2) {
                tmp = nums[i];
                nums[i] = nums[--two];
                nums[two] = tmp;
            } else
                i++;
        }
    }
}


