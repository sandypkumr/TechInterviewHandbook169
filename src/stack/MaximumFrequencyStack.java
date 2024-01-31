package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class MaximumFrequencyStack {
    Map<Integer, Deque<Integer>> freqStack;
    Map<Integer, Integer> freqElems;
    int maxFreq;

    public MaximumFrequencyStack() {
        freqStack = new HashMap<>();
        freqElems = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        freqElems.put(val, freqElems.getOrDefault(val, 0) + 1);
        int curFreq = freqElems.get(val);
        if (!freqStack.containsKey(curFreq)) {
            freqStack.put(curFreq, new ArrayDeque<>());
        }
        freqStack.get(curFreq).push(val);
        maxFreq = Math.max(maxFreq, curFreq);
    }

    public int pop() {
        int res = freqStack.get(maxFreq).pop();
        freqElems.put(res, freqElems.get(res) - 1);
        if (freqStack.get(maxFreq).isEmpty()) {
            maxFreq--;
        }
        return res;
    }
}
