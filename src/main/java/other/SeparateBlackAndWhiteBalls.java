package other;

public class SeparateBlackAndWhiteBalls {
    // https://leetcode.com/problems/separate-black-and-white-balls/
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public long minimumSteps(String s) {
        long[] sum = new long[s.length()];
        sum[s.length() - 1] = s.charAt(s.length() - 1) == '0' ? 1 : 0;

        for (int i = s.length() - 2; i >= 0; i--) {
            sum[i] = s.charAt(i) == '0' ? sum[i + 1] + 1 : sum[i + 1];
        }

        long minSwaps = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                minSwaps += sum[i];
            }
        }

        return minSwaps;
    }
}
