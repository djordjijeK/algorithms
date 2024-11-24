package other;

public class XorQueriesOfASubarray {
    // https://leetcode.com/problems/xor-queries-of-a-subarray/
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] prefix = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            prefix[i + 1] = prefix[i] ^ arr[i];
        }

        int index = 0;
        int[] result = new int[queries.length];

        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];

            result[index++] = prefix[right + 1] ^ prefix[left];
        }

        return result;
    }
}
