package array;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int majElement = nums[0];
        int rep = 1;
        for (int i = 1; i < nums.length; i++) {
            if (majElement == nums[i]) {
                rep++;
            } else {
                if (rep == 0) {
                    majElement = nums[i];
                    rep++;
                } else {
                    rep--;
                }
            }
        }
        return majElement;
    }
}
