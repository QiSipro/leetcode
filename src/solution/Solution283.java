package solution;

import java.util.Arrays;

/**
 * 移动零到末尾
 *
 * @author zhangsiqi
 * @create 2020-01-17-15:44
 */

public class Solution283 {
    public static void main(String[] args) {
        int[] ints = {1,0,1};
        moveZeroes(ints);
    }

    static public void moveZeroes(int[] nums) {
        int i = 0,j = 0, tmp;
        // i 小于 非0个数且从0 开始填入，j指向非0数
        while (j < nums.length) {
            if (nums[j] != 0){
                if(i != j) {
                    tmp = nums[i];
                    nums[i++] = nums[j];
                    nums[j] = tmp;
                }else{
                    i ++;
                }
            }
            j++;
        }

        System.out.println(Arrays.toString(nums));
    }
}