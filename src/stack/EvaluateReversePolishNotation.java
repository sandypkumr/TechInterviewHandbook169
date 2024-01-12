package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Deque<Integer> integerDeque = new ArrayDeque<>();
        for (String token : tokens) {
            switch (token) {
                case "+" -> integerDeque.push(integerDeque.pop() + integerDeque.pop());
                case "-" -> integerDeque.push(-1 * (integerDeque.pop() - integerDeque.pop()));
                case "*" -> integerDeque.push(integerDeque.pop() * integerDeque.pop());
                case "/" -> {
                    int denominator = integerDeque.pop();
                    int numerator = integerDeque.pop();
                    integerDeque.push(numerator / denominator);
                }
                default -> integerDeque.push(Integer.valueOf(token));
            }
        }
        return integerDeque.pop();
    }
}
