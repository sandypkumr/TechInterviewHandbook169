package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class TrappingRainWater {
    public int trap(int[] height) {
        Deque<Integer> barDeque = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            int prev = 0;
            while (!barDeque.isEmpty() && height[barDeque.peek()] <= height[i]) {
                int curIndex = barDeque.pop();
                res += (i-curIndex-1) * (height[curIndex] - prev);
                prev = height[curIndex];
            }
            if (!barDeque.isEmpty()) {
                res += (i - barDeque.peek() - 1) * (height[i] - prev);
            }
            barDeque.push(i);
        }
        return res;
    }
}
