package solution;

import java.util.Arrays;

/**
 * 是删除排序数组中的重复项
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，
 * 返回移除后数组的新长度。不要使用额外的数组空间，你必须在原地修改输入数组,
 * 并在使用 O(1) 额外空间的条件下完成。
 *
 * @author zhangsiqi
 * @create 2020-01-17-17:20
 */

public class Solution26 {
    public static void main(String[] args) {
//        int[] ints = {0,0,1,1,1,2,2,3,3,4};
        int[] ints = {1,1,2};
        System.out.println(removeDuplicates(ints));
        System.out.println(Arrays.toString(ints));
    }


    static public int removeDuplicates(int[] nums) {
        int i = 0;
        // i j 间隔1 同时前进， i 停留在重复的第一个， j停留在下一个非重复值
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j])
                nums[++i] = nums[j];
        }
        return i + 1;
    }
}
