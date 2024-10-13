package core.arrays;


public class ProductOfArrayExceptSelf {
    // https://leetcode.com/problems/product-of-array-except-self/description/
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int[] productExceptSelf(int[] nums) {
        int[] prefixProduct = new int[nums.length];
        int[] suffixProduct = new int[nums.length];

        prefixProduct[0] = 1;
        suffixProduct[nums.length - 1] = 1;

        for (int i = 1; i < nums.length; i++) {
            prefixProduct[i] = nums[i - 1] * prefixProduct[i - 1];
            suffixProduct[nums.length - 1 - i] = nums[nums.length - i] * suffixProduct[nums.length - i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = prefixProduct[i] * suffixProduct[i];
        }

        return nums;
    }
}