package _2024.september;

import java.util.Arrays;


public class LargestNumber {
    // https://leetcode.com/problems/largest-number/
    // Time Complexity: O(n log(n))
    // Space Complexity: O(n)
    public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strings, (a, b) -> (a + b).compareTo(b + a));

        if (strings[0].equals("0")) {
            return "0";
        }

        StringBuilder largestNumber = new StringBuilder();
        for (String str : strings) {
            largestNumber.append(str);
        }

        return largestNumber.toString();
    }
}
