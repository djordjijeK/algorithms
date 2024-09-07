package training.arrays;


public class LongestCommonPrefix {
    // https://leetcode.com/problems/longest-common-prefix/description/
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }

        int index = 0;

        outer:
        while (index < strs[0].length()) {
            char characters = strs[0].charAt(index);

            for (int i = 0; i < strs.length; i++) {
                if (index >= strs[i].length() || strs[i].charAt(index) != characters) {
                    break outer;
                }
            }

            index++;
        }


        return strs[0].substring(0, index);
    }

}
