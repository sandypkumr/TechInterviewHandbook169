package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> integerDeque = new ArrayDeque<>();
        for (int asteroid : asteroids) {
            if (integerDeque.isEmpty() || integerDeque.peek() < 0 || asteroid > 0) {
                integerDeque.push(asteroid);
            } else {
                boolean shouldInsert = true;
                while (!(integerDeque.isEmpty())) {
                    if (integerDeque.peek() < 0) {
                        break;
                    }
                    if (integerDeque.peek() < -1 * asteroid) {
                        integerDeque.pop();
                    } else if (integerDeque.peek() > -1 * asteroid) {
                        shouldInsert = false;
                        break;
                    } else {
                        integerDeque.pop();
                        shouldInsert = false;
                        break;
                    }
                }
                if (shouldInsert) {
                    integerDeque.push(asteroid);
                }
            }
        }
        int[] resArray = new int[integerDeque.size()];
        int resArrayIndex = resArray.length - 1;
        while (!integerDeque.isEmpty()) {
            resArray[resArrayIndex] = integerDeque.pop();
            resArrayIndex--;
        }
        return resArray;
    }
}
