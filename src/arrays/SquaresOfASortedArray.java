package arrays;

public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] resArr = new int[nums.length];
        int resIndex = nums.length - 1;
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            if (Math.abs(nums[start]) >= Math.abs(nums[end])) {
                resArr[resIndex--] = nums[start] * nums[start++];
            } else {
                resArr[resIndex--] = nums[end] * nums[end--];
            }
        }
        return resArr;
    }
}
