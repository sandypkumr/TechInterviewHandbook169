package string;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (res.isEmpty()) return "";
            res = getCommonPrefix(res, strs[i]);
        }
        return res;
    }

    private String getCommonPrefix(String res, String str) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < res.length() && index < str.length() && res.charAt(index) == str.charAt(index)) {
            sb.append(res.charAt(index));
            index++;
        }
        return sb.toString();
    }
}
