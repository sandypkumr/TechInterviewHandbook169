package linked_list;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode toEnd = head;
        ListNode preNth = new ListNode(-1);
        preNth.next = head;
        while (toEnd != null) {
            toEnd = toEnd.next;
            if (n == 0) {
                preNth = preNth.next;
            } else {
                n--;
            }
        }
        if (preNth.next == head) {
            head = head.next;
        } else {
            preNth.next = preNth.next.next;
        }
        return head;
    }
}
