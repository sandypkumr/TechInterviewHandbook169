package array;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        int start = 0, end = height.length - 1;
        while (start < end) {
            max = Math.max(max, (end - start) * Math.min(height[start], height[end]));
            if (height[start] > height[end]) {
                end--;
            } else {
                start++;
            }
        }
        return max;
    }
}
