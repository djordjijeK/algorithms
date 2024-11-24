package other;

import java.util.Arrays;
import java.util.HashMap;


public class RankTransformOfAnArray {
    // https://leetcode.com/problems/rank-transform-of-an-array/
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int[] arrayRankTransform(int[] arr) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);

        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 1;

        for (int i = 0; i < copy.length; i++) {
            if (!map.containsKey(copy[i])) {
                map.put(copy[i], map.getOrDefault(copy[i], rank));
                rank += 1;
            }
        }

        int[] result = new int[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = map.get(arr[i]);
        }

        return result;
    }
}
