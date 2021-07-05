package solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 项目名：    leetcode
 * 包名：      solution
 * 文件名：    Solution210
 * 创建时间:   2020-05-17-23:33
 *
 * @author zhangsiqi
 * 描述：
 */

public class Solution210 {
    // BFS 邻接表 拓扑排序
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] in = new int[numCourses]; // 入度
        int[] ans = new int[numCourses]; // 结果集
        List[] edges = new ArrayList[numCourses]; // 每个节点建立边表
        for (int i = 0; i < numCourses; i ++) {
            edges[i] = new ArrayList<Integer>();
        }
        for (int[] pre : prerequisites) {
            in[pre[0]] ++; // 后修课程+1 入度
            edges[pre[1]].add(pre[0]);  // 先修课程个指向后一课程
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i ++) {
            if (in[i] == 0) queue.add(i);  // 先将入度为0的节点加入
        }
        int k = 0;
        while (!queue.isEmpty()) {
            int cur = queue.remove(); // 出节点，对该节点指向的边消除，对应节点入度减掉
            ans[k ++] = cur;  // 加入结果集
            for (Object course : edges[cur]) {  // 遍历节点指向的边
                int c = (int)course;
                in[c] --;   // 指向节点入度-1
                if (in[c] == 0)
                    queue.add(c);
            }
        }
        return k == numCourses ? ans : new int[0];
    }
}
