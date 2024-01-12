package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Deque<Integer> tempDeque = new ArrayDeque<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!tempDeque.isEmpty() && temperatures[tempDeque.peek()] <= temperatures[i]) {
                tempDeque.pop();
            }
            answer[i] = (tempDeque.isEmpty()) ? 0 : tempDeque.peek() - i;
            tempDeque.push(i);
        }
        return answer;
    }
}
