package linked_list;

public class SwapNodeInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode first = head;
        ListNode second = head.next;
        ListNode resHead = second;
        ListNode prev = null;
        while (first != null && second != null) {
            first.next = second.next;
            second.next = first;
            if (prev != null)
                prev.next = second;
            prev = first;
            first = first.next;
            if (first != null) second = first.next;
        }
        return resHead;
    }
}
