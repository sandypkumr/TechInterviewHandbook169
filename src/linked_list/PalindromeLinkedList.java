package linked_list;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode last = head.next;
        ListNode prev = null;
        ListNode cur = head;
        ListNode nxt = head.next;
        while (last != null && last.next != null) {
            cur.next = prev;
            prev = cur;
            cur = nxt;
            nxt = nxt.next;
            last = last.next.next;
        }
        if (last != null) {
            cur.next = prev;
            prev = cur;
        }
        while (prev != null) {
            if (prev.val != nxt.val) {
                return false;
            }
            prev = prev.next;
            nxt = nxt.next;
        }
        return true;
    }
}
