package solution;

/**
 * 长度最小的子数组
 *
 * @author zhangsiqi
 * @create 2020-01-22-18:01
 */

public class Solution209 {

    public static void main(String[] args) {
        int s = 11;
        int[] nums = new int[]{2, 3, 1, 2, 4, 6};
        System.out.println(new Solution209().miSubArrayLen(s, nums));
    }

    /**
     * 滑动窗口
     *
     * @param s
     * @param nums
     * @return
     */
    public int miSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;
        int l = 0;
        int r = 0;
        int len = -1;
        int sum = nums[0];
        while (l < nums.length) {
            // 防越界
            if (sum < s && r + 1 != nums.length) {
                sum += nums[++r];
            } else {
                // 更新子数组长度
                if (sum >= s) {
                    len = len > (r - l) || len < 0 ? (r - l) : len;
                }
                // 最左扔出，l++
                sum -= nums[l++];
            }
        }
        return len + 1;
    }
}
