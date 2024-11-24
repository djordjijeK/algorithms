package twopointers;


public class SquaresOfASortedArray {
    // https://leetcode.com/problems/squares-of-a-sorted-array/description/
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        int res = nums.length - 1;
        int[] result = new int[nums.length];

        while (left <= right) {
            int leftPower = (int) Math.pow(nums[left], 2);
            int rightPower = (int) Math.pow(nums[right], 2);

            if (leftPower > rightPower) {
                result[res--] = leftPower;
                left++;
            } else {
                result[res--] = rightPower;
                right--;
            }
        }

        return result;
    }
}
