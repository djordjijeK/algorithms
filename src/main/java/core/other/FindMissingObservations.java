package core.other;

import java.util.Arrays;


public class FindMissingObservations {
    // https://leetcode.com/problems/find-missing-observations/description/
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int targetNumber = mean * (n + rolls.length) - Arrays.stream(rolls).sum();

        int remainder = targetNumber % n;
        int base = (targetNumber - remainder) / n;
        int availableSpace = (6 - base) * n;

        if (availableSpace < 0 || availableSpace < remainder) {
            return new int[]{};
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = base + remainder > 0 ? 1 : 0;
            remainder -= 1;
        }

        return result;
    }
}
