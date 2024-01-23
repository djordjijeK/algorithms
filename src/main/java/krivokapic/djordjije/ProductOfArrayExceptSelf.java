package krivokapic.djordjije;


// https://leetcode.com/problems/product-of-array-except-self/description/
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] prefixSum = new int[nums.length];
        int[] postfixSum = new int[nums.length];

        for (int index = 0; index < nums.length; index++) {
            if (index == 0) {
                prefixSum[index] = nums[index];
                continue;
            }

            prefixSum[index] = prefixSum[index - 1] * nums[index];
        }

        for (int index = nums.length - 1; index >= 0; index--) {
            if (index == nums.length - 1) {
                postfixSum[index] = nums[index];
                continue;
            }

            postfixSum[index] = postfixSum[index + 1] * nums[index];
        }

        for (int index = 0; index < nums.length; index++) {
            if (index == 0) {
                nums[index] = postfixSum[index + 1];
                continue;
            }

            if (index == nums.length - 1) {
                nums[index] = prefixSum[index - 1];
                continue;
            }

            nums[index] = prefixSum[index - 1] * postfixSum[index + 1];
        }

        return nums;
    }

}
