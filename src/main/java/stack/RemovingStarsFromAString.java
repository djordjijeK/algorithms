package stack;

public class RemovingStarsFromAString {
    /*
         // Time Complexity: O(n), n - input string length
         // Space Complexity: O(n), n - input string length
         public String removeStars(String s) {
             Stack<Character> stack = new Stack<>();

             for (int i = 0; i < s.length(); i++) {
                 if (s.charAt(i) != '*') {
                     stack.push(s.charAt(i));
                     continue;
                 }

                 if (!stack.isEmpty()) {
                     stack.pop();
                 }
             }

             StringBuilder stringBuilder = new StringBuilder();
             while (!stack.isEmpty()) {
                 stringBuilder.append(stack.pop());
             }

             return stringBuilder.reverse().toString();
         }
     */


    // https://leetcode.com/problems/removing-stars-from-a-string/
    // Time Complexity: O(n), n - input string length
    // Space Complexity: O(1)
    public String removeStars(String s) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '*') {
                stringBuilder.append(s.charAt(i));
            } else {
                stringBuilder.setLength(stringBuilder.length() - 1);
            }
        }

        return stringBuilder.toString();
    }
}
