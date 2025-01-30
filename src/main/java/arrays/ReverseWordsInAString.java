package arrays;

import java.util.ArrayDeque;


public class ReverseWordsInAString {

    // https://leetcode.com/problems/reverse-words-in-a-string/
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public String reverseWords(String s) {
        ArrayDeque<String> queue = new ArrayDeque<>();

        int index = 0;
        while (index < s.length()) {
            while (index < s.length() && s.charAt(index) == ' ') {
                index += 1;
            }

            if (index >= s.length()) {
                break;
            }

            StringBuilder stringBuilder = new StringBuilder();
            while (index < s.length() && s.charAt(index) != ' ') {
                stringBuilder.append(s.charAt(index));
                index += 1;
            }

            queue.addFirst(stringBuilder.toString());
        }

        return String.join(" ", queue);
    }

}
