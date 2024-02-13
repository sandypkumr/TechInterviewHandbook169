package linked_list;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        int carry = 0;
        ListNode res = l1;
        ListNode last = l1;
        while (l2 != null) {
            int curSum = l1.val + l2.val + carry;
            l1.val = curSum % 10;
            carry = curSum / 10;
            last = l1;
            l1 = l1.next;
            l2 = l2.next;
            if (l1 == null) {
                last.next = l2;
                l1 = l2;
                break;
            }
        }
        while (l1 != null) {
            int curSum = l1.val + carry;
            l1.val = curSum % 10;
            carry = curSum / 10;
            last = l1;
            l1 = l1.next;
        }
        if (carry == 1)
            last.next = new ListNode(1);
        return res;
    }
}
