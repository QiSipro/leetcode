package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 项目名：    leetcode
 * 包名：      solution
 * 文件名：    Solution16
 * 创建时间:   2020-05-17-23:45
 *
 * @author zhangsiqi
 * 描述：
 */

public class Solution16 {
    public static void main(String[] args) {
//        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
//        int[] nums = new int[]{0, 0, 0};
        int[] nums = new int[]{1, 2, 4, 8, 16, 32, 64, 128};
        Solution16 solution16 = new Solution16();
        int res = solution16.threeSumClosest(nums, 82);
        System.out.println(res);
    }

    public int threeSumClosest(int[] nums, int target) {
        int ans = 0;
        int len = nums.length;
        int wid = Integer.MAX_VALUE;
        if (nums == null || len < 3) return 0;
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重
            int L = i + 1;
            int R;
            while (L < len - 1) {
                R=L+1;
                while (R < len) {
                    int sum = nums[i] + nums[L] + nums[R];
                    int abs = Math.abs(target - sum);
                    if (abs == 0) return target;
                    if (abs < wid) {
                        ans = sum;
                        wid = abs;
                    }
                    R++;
                }
                L++;
            }
        }
        return ans;
    }

    public int threeSumClosestV2(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for(int i=0;i<nums.length;i++) {
            int start = i+1, end = nums.length - 1;
            while(start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if(Math.abs(target - sum) < Math.abs(target - ans))
                    ans = sum;
                if(sum > target) // 如果大于则，end端左移
                    end--;
                else if(sum < target) // 小于则 s端右移 
                    start++;
                else
                    return ans;
            }
        }
        return ans;
    }
}
