package training.twopointers;

public class TwoSumIIArrayIsSorted {
    // https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right && numbers[left] + numbers[right] != target) {
            if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[]{left + 1, right + 1};
    }
}
