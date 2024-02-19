package linked_list;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;
        int count = 0;
        ListNode last = null;
        ListNode iter = head;
        while (iter != null) {
            count++;
            last = iter;
            iter = iter.next;
        }
        k = k % count;
        if (k == 0)
            return head;
        last.next = head;
        ListNode front = head;
        ListNode back = head;
        while (front != last) {
            front = front.next;
            if (k > 0) {
                k--;
            } else {
                back = back.next;
            }
        }
        head = back.next;
        back.next = null;
        return head;
    }
}
