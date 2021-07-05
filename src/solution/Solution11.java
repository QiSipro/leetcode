package solution;

/**
 * 盛最多水的容器
 *
 * @author zhangsiqi
 * @create 2020-01-21-21:36
 */

public class Solution11 {
    public static void main(String[] args) {
        int[] ints = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new Solution11().maxArea(ints));
    }

    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        while (l < r) {
            int h = height[l] > height[r]? height[r]:height[l];
            int v = h * (r - l);
            if (max < v) max = v;
            if (height[l] <= height[r]) l++;
            else r--;
        }
        return max;
    }
}
