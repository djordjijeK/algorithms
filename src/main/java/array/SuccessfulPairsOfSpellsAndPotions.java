package array;

import java.util.Arrays;


public class SuccessfulPairsOfSpellsAndPotions {
    // https://leetcode.com/problems/successful-pairs-of-spells-and-potions/
    // Time Complexity: O(s * log(p) + p * log(p)), where p is points and s is spells array
    // Space Complexity: O(1)
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        // Sort potions array in ascending order
        Arrays.sort(potions);

        int[] result = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            result[i] = findNumberOfPotions(spells[i], potions, success);
        }

        return result;
    }


    private int findNumberOfPotions(int spell, int[] potions, long success) {
        int left = 0;
        int right = potions.length - 1;

        int index = potions.length;
        while (left <= right) {
            int mid = (left + right) / 2;

            if ((long) spell * potions[mid] >= success) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return potions.length - index;
    }
}
