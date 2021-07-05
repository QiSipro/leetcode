package solution;

/**
 * 罗马数字转整数
 *
 * @author zhangsiqi
 * @create 2020-01-17-19:51
 */

public class Solution13 {
    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }

    static public int romanToInt(String s) {
        int sum = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'I') {
                if (i != chars.length - 1 && chars[i + 1] == 'V') {
                    sum += 4;
                    i += 1;
                } else if (i != chars.length - 1 && chars[i + 1] == 'X') {
                    sum += 9;
                    i += 1;
                } else {
                    sum += 1;
                }

            } else if (chars[i] == 'V')
                sum += 5;
            else if (chars[i] == 'X') {
                if (i != chars.length - 1 && chars[i + 1] == 'L') {
                    sum += 40;
                    i += 1;
                } else if (i != chars.length - 1 && chars[i + 1] == 'C') {
                    sum += 90;
                    i += 1;
                } else {
                    sum += 10;
                }
            } else if (chars[i] == 'L')
                sum += 50;
            else if (chars[i] == 'C') {
                if (i != chars.length - 1 && chars[i + 1] == 'D') {
                    sum += 400;
                    i += 1;
                } else if (i != chars.length - 1 && chars[i + 1] == 'M') {
                    sum += 900;
                    i += 1;
                } else {
                    sum += 100;
                }
            } else if (chars[i] == 'D')
                sum += 500;
            else if (chars[i] == 'M')
                sum += 1000;
        }
        return sum;
    }

}
