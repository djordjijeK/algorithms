package krivokapic.djordjije.legacy;


// https://leetcode.com/problems/rotate-array/description/
// Time Complexity: O(n)
// Space Complexity: O(n)
public class RotateArray {

    public void rotate(int[] nums, int k) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[(i + k) % nums.length] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }

}
