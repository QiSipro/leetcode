package solution;

/**
 * 相交链表找出相交起始节点
 *
 * @author zhangsiqi
 * @create 2020-01-18-16:38
 */

public class Solution160 {


    public static void main(String[] args) {

    }

    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode la = headA;
        ListNode lb = headB;
        ListNode l = null;
        int ia = 0;
        int ib = 0;
        // 求长度
        while (la != null || lb != null) {
            if (la != null) {
                ia++;
                la = la.next;
            }
            if (lb != null) {
                ib++;
                lb = lb.next;
            }
        }
        la = headA;
        lb = headB;
        while (ia-- > ib) la = la.next;
        while (ib-- > ia) lb = lb.next;
        while (la != null && lb != null) {
            if (la == lb) {
                return la;
            }
            la = la.next;
            lb = lb.next;
        }
        return null;
    }

    /**
     * 交叉遍历
     * @param headA
     * @param headB
     * @return
     */
    static public ListNode getIntersectionNodePro(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode apointer = headA;
        ListNode bpointer = headB;
        while (apointer != bpointer) {
            apointer = (apointer == null ? headB : apointer.next);
            bpointer = (bpointer == null ? headA : bpointer.next);
        }
        return apointer;
    }


}
