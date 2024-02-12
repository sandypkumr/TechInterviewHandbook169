package linked_list;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Map<Integer, DLLNode> cacheMap;
    DLLNode left, right;
    int capacity, curCap;
    public LRUCache(int capacity) {
        cacheMap = new HashMap<>();
        this.capacity = capacity;
        curCap = 0;
    }

    public int get(int key) {
        if (!cacheMap.containsKey(key))
            return -1;
        DLLNode cur = cacheMap.get(key);
        moveToRight(cur);
        return cur.val;
    }

    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            DLLNode cur = cacheMap.get(key);
            moveToRight(cur);
            cur.val = value;
        } else {
            DLLNode cur = new DLLNode(key, value);
            if (left == null) {
                left = cur;
            } else {
                right.right = cur;
            }
            cur.left = right;
            right = cur;
            cacheMap.put(key, cur);
            if (cacheMap.size() > capacity) {
                cacheMap.remove(left.key);
                left = left.right;
                left.left = null;
            }
        }
    }

    private void moveToRight(DLLNode cur) {
        if (right != cur) {
            if (left == cur) {
                left = left.right;
                left.left = null;
            } else {
                cur.left.right = cur.right;
                cur.right.left = cur.left;
            }
            cur.left = right;
            right.right = cur;
            right = cur;
            cur.right = null;
        }
    }
}

class DLLNode {
    DLLNode left;
    DLLNode right;
    int key;
    int val;
    public DLLNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
    public DLLNode(){
    }
}
