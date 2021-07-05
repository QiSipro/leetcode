package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 项目名：    leetcode
 * 包名：      solution
 * 文件名：    Solution15
 * 创建时间:   2020-05-17-21:58
 *
 * @author zhangsiqi
 * 描述：
 */

public class Solution15 {
    public static void main(String[] args) {
//        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
//        int[] nums = new int[]{0, 0, 0};
        int[] nums = new int[]{-1,0,1};
        Solution15 solution15 = new Solution15();
        List<List<Integer>> listList = solution15.threeSum(nums);
        System.out.println(listList.toString());
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if(nums == null || len < 3) return ans;
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len ; i++) {
            if(nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
            int L = i+1;
            int R = len-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]) L++; // 去重
                    while (L<R && nums[R] == nums[R-1]) R--; // 去重
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return ans;
    }
}
