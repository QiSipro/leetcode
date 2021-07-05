package solution;

/**
 * 反转字符串
 *
 * @author zhangsiqi
 * @create 2020-01-21-21:12
 */

public class Solution344 {

    public static void main(String[] args) {

    }

    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length -1;
        while(l < r){
            swap(s,l,r);
            l++;
            r--;
        }
    }

    public void swap(char[] nums, int index1, int index2) {
        char temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
