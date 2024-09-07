package training.slidingwindow;

public class PermutationInString {
    // https://leetcode.com/problems/permutation-in-string/description/
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Map = new int[26];
        int[] s2Map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Map[s1.charAt(i) - 'a'] += 1;
            s2Map[s2.charAt(i) - 'a'] += 1;
        }

        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Map[i] == s2Map[i]) {
                matches++;
            }
        }

        int left = 0;
        for (int right = s1.length(); right < s2.length(); right++) {
            if (matches == 26) {
                return true;
            }

            int rightIndex = s2.charAt(right) - 'a';
            s2Map[rightIndex] += 1;
            if (s1Map[rightIndex] == s2Map[rightIndex]) {
                matches++;
            } else if (s1Map[rightIndex] + 1 == s2Map[rightIndex]) {
                matches--;
            }

            int leftIndex = s2.charAt(left) - 'a';
            s2Map[leftIndex] -= 1;
            if (s1Map[leftIndex] == s2Map[leftIndex]) {
                matches++;
            } else if (s1Map[leftIndex] - 1 == s2Map[leftIndex]) {
                matches--;
            }

            left += 1;
        }

        return matches == 26;
    }
}
