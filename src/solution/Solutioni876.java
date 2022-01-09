package solution;

public class Solutioni876 {

    /**
     * 使用快慢指针，因为要找中间节点，所以快指针前进两步，慢指针前进一步，两倍关系
     * 同理可推，1/3,1/4处的节点
     *
     * @param head
     * @return
     */
    public ListNode middleNode_fast_slow(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 一个节点k 一直向前，记录结点的个数，
     * 另一个节点i 记录中间节点的位置，一直指向k/2的位置 如果是偶数返回nodej->next;
     */
    public ListNode middleNode(ListNode head) {
        // 遍历节点
        ListNode k = head;
        // 指向中间节点
        ListNode j = head;
        // 记录结点的个数
        int n = 0;
        // 指向中间节点
        int i = 1;
        while (k != null) {
            n++;
            while (i < n / 2 + 1) {
                // 向后移动
                j = j.next;
                i++;
            }
            k = k.next;
        }
        return j;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
