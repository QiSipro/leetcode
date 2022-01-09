package solution;

public class Solution557 {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        String r;
        r = reverseWords(s);
        System.out.println(r);
    }

    /**
     * 很慢的方法,
     * @param s 输入字符串
     * @return
     */
    static public String reverseWords_StringBuffer(String s) {
        // 找出空格的位置
        // 首先 r向右寻找空格，到达下一个字符是空格或者字符串末尾停下
        int r = 0;
        StringBuffer st = new StringBuffer();
        while (r < s.length()) {
            // 找到空格或字符串末尾
            if (r == s.length() - 1 || s.charAt(r + 1) == ' ') {
                reverseString(s, st, r);
                if(r>=0 && r < s.length()-1)
                    st.append(" ");
                // 跳过空格
                r += 2;
            } else {
                r++;
            }
        }
        return st.toString();
    }

    static public void reverseString(String s, StringBuffer st, int r) {
        // 没有移动到空格位置 或 字符串头
        while (s.charAt(r) != ' ') {
            st.append(s.charAt(r--));
            if (r == -1)
                break;
        }
    }
    static public String reverseWords(String s) {
        // 找出空格的位置
        // 首先 r向右寻找空格，到达下一个字符是空格或者字符串末尾停下
        char arrs[] = s.toCharArray();
        // 左右边界
        int l = 0,r = 0;
        for(int k = 0; k < s.length(); k++) {
            // 找到空格或字符串末尾
            if (k == s.length() - 1 || s.charAt(k + 1) == ' ') {
                r = k;
                // 开始翻转
                while(r > l){
                    // 交换
                    arrs[l] = (char) (arrs[l] ^ arrs[r]);
                    arrs[r] = (char) (arrs[r] ^ arrs[l]);
                    arrs[l] = (char) (arrs[l] ^ arrs[r]);
                    l++;
                    r--;
                }
                // 跳过空格
                l = k+2;
            }
        }
        return new String(arrs);
    }
}
