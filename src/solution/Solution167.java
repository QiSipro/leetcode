package solution;

/**
 * 输入有序数组，找到两个数使得他们相加之和等于目标数
 *
 * @author zhangsiqi
 * @create 2020-01-21-20:34
 */

public class Solution167 {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] numbers, int target) {
        // 对撞指针
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] > target) {
                r--;
            } else if (numbers[l] + numbers[r] < target) {
                l++;
            } else {
                return new int[]{l+1, r+1};
            }
        }
        return numbers;
    }
}
