package stack;

public class TrappingRainWater {
    public int trap(int[] height) {
        int res = 0;
        int maxL = height[0], maxR = height[height.length - 1], lIndex = 0, rIndex = height.length - 1;
        while (lIndex < rIndex) {
            if (maxL <= maxR) {
                if (height[++lIndex] < maxL) {
                    res += maxL - height[lIndex];
                } else {
                    maxL = height[lIndex];
                }
            } else {
                if (height[--rIndex] < maxR) {
                    res += maxR - height[rIndex];
                } else {
                    maxR = height[rIndex];
                }
            }
        }
        return res;
    }
}
