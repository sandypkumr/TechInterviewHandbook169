package linked_list;

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode left = head;
        ListNode right = getMidNode(head);
        ListNode tmp = right.next;
        right.next = null;
        right = tmp;
        left = sortList(left);
        right = sortList(right);
        return mergeList(left, right);
    }

    private ListNode mergeList(ListNode left, ListNode right) {
        ListNode tail = new ListNode(-1);
        ListNode preHead = tail;
        while (left != null && right != null) {
            if (left.val < right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        if (left != null) {
            tail.next = left;
        } else {
            tail.next = right;
        }
        return preHead.next;
    }

    private ListNode getMidNode(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
