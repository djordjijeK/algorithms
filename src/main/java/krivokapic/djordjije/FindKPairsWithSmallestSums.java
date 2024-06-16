package krivokapic.djordjije;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


// https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/
public class FindKPairsWithSmallestSums {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Tuple> priorityQueue = new PriorityQueue<>(k, Comparator.comparingInt(tuple -> (nums1[tuple.i] + nums2[tuple.j])));

        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }

        for (int i = 0; i < nums1.length && i < k; i++) {
            priorityQueue.add(new Tuple(i, 0));
        }

        while (k-- > 0 && !priorityQueue.isEmpty()) {
            Tuple tuple = priorityQueue.poll();
            result.add(Arrays.asList(nums1[tuple.i], nums2[tuple.j]));

            if (tuple.j + 1 < nums2.length) {
                priorityQueue.add(new Tuple(tuple.i, tuple.j + 1));
            }
        }

        return result;
    }

    record Tuple(int i, int j) {}



}
