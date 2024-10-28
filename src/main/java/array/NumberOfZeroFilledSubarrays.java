package array;

public class NumberOfZeroFilledSubarrays {
    // https://leetcode.com/problems/number-of-zero-filled-subarrays/
    // Time Complexity: O(n), n - number of array elements
    // Space Complexity: O(1)
    public long zeroFilledSubarray(int[] nums) {
        long result = 0;
        long currentCount = 0;
        for (int current : nums) {
            if (current == 0) {
                currentCount += 1;
            } else {
                currentCount = 0;
            }

            result += currentCount;
        }

        return result;
    }
}
