package array;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int curNonZeroPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[curNonZeroPos++] = nums[i];
            }
        }
        for (int i = curNonZeroPos; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
