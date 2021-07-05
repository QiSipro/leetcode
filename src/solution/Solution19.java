package solution;

/**
 * 删除链表的倒数第N个结点
 *
 * @author zhangsiqi
 * @create 2020-01-18-15:59
 */

public class Solution19 {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        ListNode head = new ListNode(nums[0]);
        ListNode h = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode tmp = new ListNode(nums[i]);
            tmp.next = null;
            h.next = tmp;
            h = h.next;
        }

        ListNode listNode = removeNthFromEnd(head, 1);
        while (listNode != null) {
            System.out.print(listNode.val + ",");
            listNode = listNode.next;
        }

    }

    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static public ListNode removeNthFromEnd(ListNode head, int n) {
        // 加个头节点省事
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode p = node;
        ListNode q = node;
        // q 移动 n 个提前量
        while (n-- > 0 && q.next != null) q = q.next;
        // 一起移动
        while (q.next != null) {
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return node.next;
    }
}
