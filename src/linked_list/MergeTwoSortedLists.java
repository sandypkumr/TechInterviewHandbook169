package linked_list;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode preRes = new ListNode(-1);
        ListNode iter = preRes;
        while (list1 != null && list2 != null) {
            if (list2.val < list1.val) {
                iter.next = list2;
                list2 = list2.next;
            } else {
                iter.next = list1;
                list1 = list1.next;
            }
            iter = iter.next;
        }
        if (list1 != null) {
            iter.next = list1;
        } else {
            iter.next = list2;
        }
        return preRes.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}