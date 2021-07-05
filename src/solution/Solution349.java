package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 项目名：    leetcode
 * 包名：      solution
 * 文件名：    Solution349
 * 创建时间:   2020-05-17-20:52
 *
 * @author zhangsiqi
 * 描述：
 */

public class Solution349 {

    public static void main(String[] args) {

    }

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> res = new HashSet<>();
        HashSet<Integer> n1 = new HashSet<>();
        HashSet<Integer> n2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++)
            n1.add(nums1[i]);
        for (int i = 0; i < nums2.length; i++)
            n2.add(nums2[i]);
        return n1.size() > n2.size() ? set_intersection(n2, n1) : set_intersection(n1, n2);
    }

    public int[] set_intersection(HashSet<Integer> s1, HashSet<Integer> s2) {
        int[] res = new int[s1.size()];
        int idx = 0;
        for (Integer i : s1) {
            if (s2.contains(i)) res[idx++]=i;
        }
        return Arrays.copyOf(res,idx);
    }
}
