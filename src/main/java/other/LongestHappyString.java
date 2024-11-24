package other;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


public class LongestHappyString {
    // https://leetcode.com/problems/longest-happy-string/
    // Time Complexity: O(a + b + c)
    // Space Complexity: O(1)
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder stringBuilder = new StringBuilder(a + b + c);

        Comparator<Tuple> tupleComparator = Comparator.comparingInt(Tuple::count).reversed();
        Queue<Tuple> priorityQueue = new PriorityQueue<>(tupleComparator);

        if (a > 0) {
            priorityQueue.add(new Tuple('a', a));
        }
        if (b > 0) {
            priorityQueue.add(new Tuple('b', b));
        }
        if (c > 0) {
            priorityQueue.add(new Tuple('c', c));
        }

        while (!priorityQueue.isEmpty()) {
            Tuple tuple = priorityQueue.poll();
            int length = stringBuilder.length();

            if (length >= 2 && stringBuilder.charAt(length - 1) == tuple.c() && stringBuilder.charAt(length - 2) == tuple.c()) {
                if (priorityQueue.isEmpty()) {
                    break;
                }


                Tuple nextTuple = priorityQueue.poll();
                stringBuilder.append(nextTuple.c());
                if (nextTuple.count() - 1 > 0) {
                    priorityQueue.add(new Tuple(nextTuple.c(), nextTuple.count() - 1));
                }

                priorityQueue.add(tuple);
            } else {
                stringBuilder.append(tuple.c());
                if (tuple.count() - 1 > 0) {
                    priorityQueue.add(new Tuple(tuple.c(), tuple.count() - 1));
                }
            }
        }

        return stringBuilder.toString();
    }


    private record Tuple(char c, int count) {
    }
}
