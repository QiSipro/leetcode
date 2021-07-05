package solution;

/**
 * 验证回文串
 *
 * @author zhangsiqi
 * @create 2020-01-21-20:51
 */

public class Solution125 {
    public static void main(String[] args) {
        String s = new String("A man, a plan, a canal: Panama");
        String s1 = new String("rac a car");
        System.out.println(new Solution125().isPalindrome(s1));
    }

    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            boolean bl = Character.isLetterOrDigit(s.charAt(l));
            boolean br = Character.isLetterOrDigit(s.charAt(r));
            if (bl && br) {
                if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                    return false;
                }
                l++;
                r--;
            }
            if (!bl) l++;
            if (!br) r--;
        }
        return true;
    }
}
