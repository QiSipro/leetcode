package solution;

import java.util.HashMap;

/**
 * @author zhangsiqi
 * @create 2020-01-16-16:37
 */

public class Solution1 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] nums = new int[]{3, 2, 4};

        int[] ints = twoSum(nums, 6);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    /**
     * 暴力解法
     *
     * @param nums
     * @param target
     * @return
     */
    static public int[] twoSum(int[] nums, int target) {

        int length = nums.length;
        int i = 0;
        int j = 0;

        for (i = 0; i < length; i++) {
            for (j = 0; j < length; j++) {
                if (j == i) {
                    continue;
                }
                if (nums[i] + nums[j] == target) {
                    int[] index = new int[]{i, j};
                    return index;
                }
            }
        }
        return null;
    }

    /**
     * 从第一个数开始，用target减它，找到差值去map里找，没找到就把减数作为key
     * index 作为value放入map，最后查找成功应先返回map.get,因为map.get是前面的数
     *
     * @param nums
     * @param target
     * @return
     */
    static public int[] twoSum_pro(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(16);
        int sum;
        for (int i = 0; i < nums.length; i++) {
            sum = target - nums[i];
            //获取另一个数
            if (map.get(sum) != null) {
                return new int[]{map.get(sum), i};
            } else {
                // 这个数没找到另一半放进去待寻找
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
