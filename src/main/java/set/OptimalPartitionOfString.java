package set;

import java.util.HashSet;
import java.util.Set;


public class OptimalPartitionOfString {
    // https://leetcode.com/problems/optimal-partition-of-string/
    // Time Complexity: O(n), n - number of characters in a string
    // Space Complexity: O(1), at most of 26 characters
    public int partitionString(String s) {
        Set<Character> set = new HashSet<>();
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);

            if (set.contains(character)) {
                result += 1;
                set = new HashSet<>();
            }

            set.add(character);
        }

        return result + 1;
    }
}
