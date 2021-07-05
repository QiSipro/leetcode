package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 寻找两个有序数组的中位数
 *
 * @author zhangsiqi
 * @create 2020-01-16-22:10
 */

public class Solution4 {

    public static void main(String[] args) {
        int[] ints1 = {1, 2};
        int[] ints2 = {3, 4};
        System.out.println(findMedianSortedArrays(ints1, ints2));

    }


    static public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            nums[i] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            nums[i + nums1.length] = nums2[i];
        }
        Arrays.sort(nums);
        int length = nums.length;
        double result;
        // 如果是偶数
        if (length % 2 == 0) {
            length /= 2;
            result = nums[length] + nums[length - 1];
            result /= 2;
        } else {
            length /= 2;
            result = (double) nums[length];
        }
        return result;
    }
}


