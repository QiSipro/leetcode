package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到字符串中所有字母异位词
 *
 * @author zhangsiqi
 * @create 2020-01-22-21:13
 */

public class Solution438 {
    public static void main(String[] args) {
        String s, p;
        s = "cbaebabacd";
        p = "abc";
        List<Integer> anagrams = new Solution438().findAnagrams(s, p);
        for (Integer anagram : anagrams) {
            System.out.print(anagram + " ");
        }
    }

    /**
     * 创建双数组，每添加一个字母则在数组中对应位置+1，
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        // 固定大小滑动窗口
        int[] freqs = new int[26];
        int[] freqp = new int[26];
        // 对照组，不怕重复字母
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < p.length(); i++)
            freqp[p.charAt(i)-'a']++;
        int l = 0;
        int r;
        // 先添加窗口试试水
        for (r = 0; r < p.length(); r++)
            freqs[s.charAt(r)-'a']++;
        // 归为[l,r]
        r -= 1;
        while (l < s.length()) {
            if (compare(freqp, freqs))
                // 存储结果
                list.add(l);
            // 后移删一个添一个
            freqs[s.charAt(l++)-'a']--;
            if (r + 1 < s.length())
                freqs[s.charAt(++r)-'a']++;
        }

        return list;
    }

    private boolean compare(int[] freq1, int[] freq2) {
        for (int i = 0, j = 0; i < freq1.length && j < freq2.length; j++, i++)
            if (freq1[i] != freq2[j])
                return false;
        return true;
    }
}
