package solution;

/**
 * 无重复字符的最长子串
 *
 * @author zhangsiqi
 * @create 2020-01-16-20:52
 */

public class Solution3 {

    public static void main(String[] args) {
        String s = new String();
        s = "abcdab";
        System.out.println(new Solution3().lengthOfLongestSubstringPro(s));
    }

     public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int count;
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            count = 0;
            for (int j = i; j < s.length(); j++) {
                String s1 = str.toString();
                int indexOf = s1.indexOf(s.charAt(j));
                // 不在
                if (indexOf <= -1) {
                    // 添加
                    str.append(s.charAt(j));
                    count++;
                } else {
                    // 在, 从重复字符下一个字符开始算
                    i = s.indexOf(s.charAt(j), i);
                    // 清空
                    str.delete(0, str.length());
                    break;
                }
            }
            if (count > max) {
                max = count;
            }
        }
        return max;
    }

    public int lengthOfLongestSubstringPro(String s) {
        int[] freq = new int[256];
        int l = 0;
        int r = -1;
        int res = 0;
        while (l < s.length()) {
            if (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0)
                freq[s.charAt(++r)]++;
            else
                freq[s.charAt(l++)]--;
            res = res < (r - l + 1) ? (r - l + 1) : res;
        }
        return res;
    }
}
