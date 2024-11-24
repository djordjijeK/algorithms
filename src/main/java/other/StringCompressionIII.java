package other;

public class StringCompressionIII {
    // https://leetcode.com/problems/string-compression-iii/description/
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public String compressedString(String word) {
        StringBuilder stringBuilder = new StringBuilder();

        int left = 0;
        int right = 0;

        while (right < word.length()) {
            while (right < word.length() && word.charAt(right) == word.charAt(left) && right - left < 9) {
                right++;
            }

            stringBuilder.append(right - left).append(word.charAt(left));
            left = right;
        }

        return stringBuilder.toString();
    }
}
