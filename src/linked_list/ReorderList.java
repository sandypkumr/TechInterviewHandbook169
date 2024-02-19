package linked_list;

public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return;
        ListNode right = reverseFrom(getMidNode(head));
        ListNode left = head;
        ListNode temp = new ListNode(-1);
        while (left != null && left != right) {
            temp.next = left;
            temp = temp.next;
            left = left.next;
            temp.next = right;
            temp = temp.next;
            right = right.next;
        }
        temp.next = left;
        ListNode iter = head;
        while (iter != null) {
            System.out.println(iter.val);
            iter = iter.next;
        }
    }

    private ListNode reverseFrom(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode nxt;
        while (cur != null) {
            nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        return prev;
    }

    private ListNode getMidNode(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
