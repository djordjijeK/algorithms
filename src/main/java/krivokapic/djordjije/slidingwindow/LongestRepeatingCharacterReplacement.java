package krivokapic.djordjije.slidingwindow;


public class LongestRepeatingCharacterReplacement {
    // https://leetcode.com/problems/longest-repeating-character-replacement/description/
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int longestSequence = 0;

        int[] characters = new int[26];
        characters[s.charAt(right) - 'A'] += 1;

        while (true) {
            int windowSize = right - left + 1;
            int maxFrequency = findMax(characters);

            if (windowSize - maxFrequency > k) {
                characters[s.charAt(left) - 'A'] -= 1;
                left += 1;
                continue;
            }

            if (windowSize > longestSequence) {
                longestSequence = windowSize;
            }

            right += 1;
            if (right > s.length() - 1) {
                break;
            }
            characters[s.charAt(right) - 'A'] += 1;
        }

        return longestSequence;
    }


    private int findMax(int[] frequencies) {
        int maxFrequency = 0;

        for (int frequency : frequencies) {
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
            }
        }

        return maxFrequency;
    }
}
