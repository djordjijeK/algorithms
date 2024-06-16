package krivokapic.djordjije;

import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;


// https://leetcode.com/problems/patching-array/description/
public class PatchingArray {

    public int minPatches(int[] nums, int n) {
        Set<Integer> sums = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            calculateSums(nums, i, 0, sums);
        }

        int patches = 0;
        for (int i = 1; i <= n; i++) {
            if (sums.contains(i)) {
                continue;
            }

            patches += 1;

            int finalI = i;
            sums.addAll(sums.stream().map(sum -> sum + finalI).collect(Collectors.toSet()));
            sums.add(finalI);
        }

        return patches;
    }

    private void calculateSums(int[] nums, int start, int sum, Set<Integer> set) {
        sum += nums[start];
        set.add(sum);

        for (int i = start + 1; i < nums.length; i++) {
            calculateSums(nums, i, sum, set);
        }
    }

}
