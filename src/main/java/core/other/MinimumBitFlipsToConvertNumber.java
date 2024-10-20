package core.other;

public class MinimumBitFlipsToConvertNumber {
    // https://leetcode.com/problems/minimum-bit-flips-to-convert-number/
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public int minBitFlips(int start, int goal) {
        String result = Integer.toBinaryString(start ^ goal);
        int bitFlips = 0;

        for (int i = 0; i < result.length(); i++) {
            bitFlips += result.charAt(i) == '1' ? 1 : 0;
        }

        return bitFlips;
    }
}
