package krivokapic.djordjije.legacy.easy.medium.medium;


import java.util.Arrays;


// https://leetcode.com/problems/3sum-closest/description/
// Time Complexity: O(n^2)
// Space Complexity: O(1)
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int result = nums[0] + nums[1] + nums[nums.length - 1];

        for (int index = 0; index < nums.length; index++) {
            int left = index + 1;
            int right = nums.length - 1;

            while (left < right) {
                int currentTriplet = nums[index] + nums[left] + nums[right];

                if (Math.abs(target - currentTriplet) < Math.abs(target - result)) {
                    result = currentTriplet;
                }

                if (target - currentTriplet > 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

}
