package leetCode.solution179;

import java.util.Arrays;

public class Solution179 {
    public String largestNumber(int[] nums) {
        String[] numStrings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrings[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(numStrings, (a, b) -> (b + a).compareTo(a + b));
        if (numStrings[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (String numStr : numStrings) {
            sb.append(numStr);
        }
        return sb.toString();
    }
}