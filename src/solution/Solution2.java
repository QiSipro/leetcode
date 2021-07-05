package solution;

import java.util.List;

/**
 * 链表表示连个非负整数，各位逆序存储，每个节点存一位数字，求和
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author zhangsiqi
 * @create 2020-01-16-17:36
 */

public class Solution2 {
    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(9);
        node2.next = node3;
        addTwoNumbers(node1, node2);

    }

    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 两链表一样长吗？ 假设不同长度。
     * 从个位开始相加若大于10则取出各位，保存 1 加到10位，以此类推。
     * 若其中一个链表先遍历完毕，则将另一条链表后的数拿来接上。
     *
     * @param l1
     * @param l2
     * @return
     */
    static public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 先判断长度，取长链表存储。
        ListNode h1 = l1;
        ListNode h2 = l2;
        ListNode l, t;
        int i, j, sum, next = 0;
        while (h1 != null && h2 != null) {
            h1 = h1.next;
            h2 = h2.next;
        }
        // 以长链表为头
        if (h1 == null) {
            l = l2;
            t = l1;
        } else {
            l = l1;
            t = l2;
        }
        // 长链表开始合并, l 指向长链， t 指向短链  h1, h2 废物利用再作指针。
        h1 = l;
        while (l != null) {
            i = l.val;
            // 短链已结束
            if (t != null) {
                j = t.val;
            } else {
                j = 0;
            }
            sum = i + j + next;
            if (sum >= 10) {
                // 进位
                next = 1;
                // 保留个位数
                sum -= 10;
            } else {
                next = 0;
            }
            // 保留各位
            l.val = sum;
            // 若已是最后一个基点但是还有进位, 插入
            if (l.next == null && next != 0) {
                ListNode node = new ListNode(0);
                node.next = null;
                l.next = node;
            }
            // 向下移动
            l = l.next;
            if (t != null) {
                t = t.next;
            }
        }
        return h1;
    }
}
