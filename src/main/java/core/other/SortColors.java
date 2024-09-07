package core.other;


// https://leetcode.com/problems/sort-colors/description/
// Time Complexity: O(n)
// Space Complexity: O(1)
public class SortColors {

    public void sortColors(int[] nums) {
        int reds = 0;
        int whites = 0;
        int blues = 0;

        for (int num : nums) {
            if (num == 0) {
                reds++;
            } else if (num == 1) {
                whites++;
            } else if (num == 2) {
                blues++;
            }
        }

        int index = 0;
        while (reds-- > 0) {
            nums[index++] = 0;
        }
        while (whites-- > 0) {
            nums[index++] = 1;
        }
        while (blues-- > 0) {
            nums[index++] = 2;
        }
    }

}
