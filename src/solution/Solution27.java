package solution;

import java.util.Arrays;

/**
 * 移除元素，类似283（移除零）
 *
 * @author zhangsiqi
 * @create 2020-01-17-17:10
 */

public class Solution27 {
    public static void main(String[] args) {
        int[] ints = {1, 0, 1};
        System.out.println(removeElement(ints, 0));
        System.out.println(Arrays.toString(ints));
    }

    static public int removeElement(int[] nums, int val) {

        int i = 0;
        // i 小于 非0个数且从0 开始填入，j指向非0数
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val)
                nums[i++] = nums[j];
        }
        return i;
    }
}
