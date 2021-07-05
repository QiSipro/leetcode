package solution;

import java.util.Arrays;

/**
 * 数组归并
 *
 * @author zhangsiqi
 * @create 2020-01-19-16:07
 */

public class Solution88 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{2,0};
        int[] nums2 = new int[]{1};
        merge(nums1, 1, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 简单合并无需多言
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    static public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        else if (m == 0)
            for (int i = 0; i < nums2.length; i++)
                nums1[i] = nums2[i];
        int[] ints = new int[m];
        for (int i = 0; i < ints.length; i++) ints[i] = nums1[i];
        int i, j, k;
        i = j = k = 0;
        while (i < nums1.length) {
            while (j < m && ints[j] <= nums2[k]) nums1[i++] = ints[j++];
            if (j == m) while (k < n) nums1[i++] = nums2[k++];
            while (k < n && ints[j] > nums2[k]) nums1[i++] = nums2[k++];
            if (k == n) while (j < m) nums1[i++] = ints[j++];
        }
    }
}
