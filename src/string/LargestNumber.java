package string;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    private static class CustomStringComparator implements Comparator<String> {

        @Override
        public int compare(String a, String b) {
            String aStr = a + b;
            String bStr = b + a;
            return bStr.compareTo(aStr);
        }
    }

    public String largestNumber(int[] nums) {
        String[] numsStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsStr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numsStr, new CustomStringComparator());
        if (numsStr[0].equals("0")) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        for (String member: numsStr) {
            res.append(member);
        }
        return res.toString();
    }
}
