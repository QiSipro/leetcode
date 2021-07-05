package solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 项目名：    leetcode
 * 包名：      solution
 * 文件名：    Solution350
 * 创建时间:   2020-05-17-21:24
 *
 * @author zhangsiqi
 * 描述：
 */

public class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        int len;
        if (nums1.length > nums2.length) {
            len = nums2.length;
        } else {
            len = nums1.length;
        }
        int[] res = new int[len];
        int idx = 0;
        Map<Integer, Integer> m1 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            m1.merge(nums1[i],1,Integer::sum);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (m1.get(nums2[i]) > 0) {
                m1.merge(nums2[i],  -1,Integer::sum);
                res[idx++] = nums2[i];
            }
        }
        return Arrays.copyOf(res, idx);
    }
}
