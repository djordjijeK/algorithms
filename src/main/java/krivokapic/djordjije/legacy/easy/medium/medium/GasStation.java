package krivokapic.djordjije.medium;

import java.util.Arrays;


// https://leetcode.com/problems/gas-station/description/
// Time Complexity: O(n)
// Space Complexity: O(1)
public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) {
            return -1;
        }

        int total = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];

            if (total < 0) {
                total = 0;
                index = i + 1;
            }
        }

        return index;
    }

}
