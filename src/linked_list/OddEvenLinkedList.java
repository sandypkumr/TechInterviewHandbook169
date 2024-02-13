package linked_list;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode evenHeadInit = evenHead;
        ListNode oddEnd = null;
        while (oddHead != null && evenHead != null) {
            oddHead.next = evenHead.next;
            oddEnd = oddHead;
            oddHead = oddHead.next;
            if (oddHead != null) {
                evenHead.next = oddHead.next;
                evenHead = evenHead.next;
            }
        }
        if (oddHead != null) {
            oddHead.next = evenHeadInit;
        } else {
            oddEnd.next = evenHeadInit;
        }
        return head;
    }
}
