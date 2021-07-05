package solution;

/**
 * 返回包含目标字符串所有字符的最短子串
 *
 * @author zhangsiqi
 * @create 2020-02-13-22:09
 */

public class Solution76 {
    public static void main(String[] args) {
//        String s = "ADOBECODEBANC";
//        String t = "ABC";
//        String s = "aaaaaaaaaaaabbbbbcdd";
//        String t = "abcdd";
        String s = "acbbaca";
        String t = "aba";
        System.out.println(minWindow(s, t));
    }

    /**
     * 使用滑动窗口，找出S中包含T的最短字符串并返回  字符不能重复
     * 需要将滑动窗口中的字符标记出来，若遇到重复字符则直接跳到重复字符后
     * 目标：O（n)解决
     * <p>
     * 方法：左收缩，右扩张。
     * 首先扩张，判断是否包含所有字符，若没有则继续扩张，若是则进行左收缩，
     * 当收缩到非包含所有字符，进行扩张。
     * 当判断最左端字符的个数是否与目标字符相等时，判断是否包含所有字符。
     * 若包含则更新，不包含则扩张。
     *
     * @param s 给定字符串
     * @param t 包含T
     * @return
     */
    static public String minWindow(String s, String t) {

        int l = 0, r = 0, lw = 0, rw = 0; // 记录子字符串的左右位置 [lw,rw)
        int tlen = t.length();
        int slen = s.length();
        int[] freqp = new int[255];
        int[] tfreqp = new int[255];
        for (int i = 0; i < tlen; i++) {
            tfreqp[t.charAt(i)]++;
        }

        while (rw < slen) {
            // 如果不是全包含,则添加   扩张操作
            if (!checkContain(freqp, tfreqp)) {
                freqp[s.charAt(rw++)]++;
            }
            if (checkContain(freqp, tfreqp)) {// 全包含进行收缩
                if (rw - lw >= tlen) {
                    if (rw - lw < r - l || (r == 0 && l == 0)) { // 如果比已存的字符串短,或者是第一次更新
                        l = lw;
                        r = rw;
                    }
                }
                while (lw < rw) {
                    // 如果是目标字符，且个数相等，停止收缩
                    if (tfreqp[s.charAt(lw)] > 0 && freqp[s.charAt(lw)] == tfreqp[s.charAt(lw)]) {
                        if (rw - lw >= tlen) {
                            if (rw - lw < r - l || (r == 0 && l == 0)) { // 如果比已存的字符串短,或者是第一次更新
                                l = lw;
                                r = rw;
                            }
                        }
                        freqp[s.charAt(lw)]--;
                        lw++;
                        break;
                    } else { // 收缩
                        freqp[s.charAt(lw)]--;
                        lw++;
                    }
                }
            }
        }
        return s.substring(l, r);
    }

    static private boolean checkContain(int[] freq, int[] tfreq) {
        for (int i = 0; i < 255; i++)
            // 如果小于，代表tfreq中有的freq中没有
            if (freq[i] < tfreq[i])
                return false;
        return true;
    }
}
