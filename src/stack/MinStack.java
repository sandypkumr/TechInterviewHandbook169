package stack;

public class MinStack {
    MinStackNode head = null;
    public MinStack() {

    }

    public void push(int val) {
        MinStackNode cur = new MinStackNode();
        cur.val = val;
        cur.prev = head;
        cur.min = (head == null) ? val : Math.min(val, head.min);
        head = cur;
    }

    public void pop() {
        head = head.prev;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}

class MinStackNode {
    int val;
    int min;
    MinStackNode prev;
}
