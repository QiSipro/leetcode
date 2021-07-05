package solution;

/**
 * double幂
 *
 * @author zhangsiqi
 * @create 2020-01-17-20:20
 */

public class Solution50 {

    public static void main(String[] args) {
        System.out.println(myPowPro(2, 3));
    }

    /**
     * 偷鸡解法
     *
     * @param x
     * @param n
     * @return
     */
    static public double myPow(double x, int n) {
        return Math.pow(x, n);
    }

    /**
     * @param x
     * @param n
     * @return
     */
    static public double myPowPro(double x, int n) {
        if (n == 0) return 1;
        if (n > 0) return qpow(x, n);
        // 化真幂次，取倒数
        if (n < 0) return 1 / qpow(x, -n);
        return 1.0;
    }

    /**
     * 采用分治思想。例如2**9
     * 暴力法： 2*2*2*2*2*2*2*2*2 O(n)
     * 取2^2成4次也可以，但是若幂次不规则则不好确定
     * 9 = 1001 即 2^3 + 2^0，对x来说只需要  1*x^(2^0)*x^(2^3);
     * <p>
     * x = 2; n = 1001;
     * 1    0    0    1
     * x^8  x^4  x^2  x
     * 如果是 n & 1 = 1 则乘入res
     * n >>= 1; n 右移一次 x 翻倍
     *
     * @param x
     * @param n
     * @return
     */
    static private double qpow(double x, int n) {
        int res = 1;
        while (n > 0) {
            if ((n & 1) > 0) res *= x;
            n >>= 1;
            x *= x;
        }
        return res;
    }

    /**
     * 二分法思想
     * 若 n = 9, 取 x^4 * x^4 * x , x^4 = x^2*x^2 , x^2 = x * x  减少了一半操作 O(logn)
     * 若 n = 8, 取 x^4 * x^4 , x^4 = x^2*x^2 ,  x^2 = x * x
     *
     * @param x
     * @param n
     * @return
     */
    static double myPowBinary(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        double half = myPow(x, n / 2);
        double rest = myPow(x, n % 2);
        return rest * half * half;
    }

}
