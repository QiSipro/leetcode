package solution;

/**
 * 找到小镇法官
 *
 * @author zhangsiqi
 * @create 2020-01-16-16:45
 */

public class Solution997 {
    public static void main(String[] args) {
        int N = 2;
        int[][] trust = new int[][]{{1, 2}};
        System.out.println(Solution997.findJudge(N, trust));
        System.out.println(findJudgePro(N, trust));
    }

    static public int findJudge(int N, int[][] trust) {
        // 邻接表 下标从1开始
        int[][] people = new int[N + 1][N + 1];
        for (int i = 0; i < trust.length; i++) {
            int l = trust[i][0];
            int r = trust[i][1];
            people[l][r] = 1;
        }
        int i, j;
        for (i = 1; i < people.length; i++) {
            // 看这一行是否全为0
            for (j = 1; j < people[i].length; j++) {
                // 这行中有不为0的，法官不相信任何人所以这一行不许有1
                if (people[i][j] != 0) {
                    break;
                }
            }
            // 跳过
            if (j < people.length) {
                continue;
            }
            // 行中没有不为0的，查看列中是否全为1，以i为列
            for (j = 1; j < people.length; j++) {
                //如果这列中有不为1且不是法官自己
                if (people[j][i] != 1 && j != i) {
                    break;
                }
            }
            // 如果找到最后一个人都没问题，那就是i了
            if (j >= people.length) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 由于法官出度为：0，入度为：n-1
     * 用两个数组表示出度和入度
     *
     * @param N
     * @param trust
     * @return
     */
    static public int findJudgePro(int N, int[][] trust) {
        int[] in = new int[N + 1];
        int[] out = new int[N + 1];
        for (int[] i : trust) {
            out[i[0]]++;
            in[i[1]]++;
        }
        for (int i = 1; i <= N; i++) {
            if (in[i] == N - 1 && out[i] == 0) {
                return i;
            }
        }
        return -1;
    }

}
