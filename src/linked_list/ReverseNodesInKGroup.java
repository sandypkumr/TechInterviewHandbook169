package linked_list;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head.next == null || k == 1)
            return head;
        ListNode kthNode = getKthNode(head, k);
        ListNode start = head;
        ListNode prev = null;
        ListNode resHead = null;
        while (kthNode != null) {
            ListNode kPlusOne = kthNode.next;
            ListNode reverseHead = reverseFromStartToK(start, kPlusOne);
            if (prev != null) {
                prev.next = reverseHead;
            } else {
                resHead = reverseHead;
            }
            start.next = kPlusOne;
            prev = start;
            start = kPlusOne;
            kthNode = getKthNode(start, k);
        }
        return resHead;
    }

    private ListNode reverseFromStartToK(ListNode start, ListNode kPlusOne) {
        ListNode prev = null;
        ListNode cur = start;
        ListNode nxt;
        while (cur != kPlusOne) {
            nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        return prev;
    }

    private ListNode getKthNode(ListNode head, int k) {
        if (head == null) return null;
        while (k > 1) {
            head = head.next;
            if (head == null) return null;
            k--;
        }
        return head;
    }
}
