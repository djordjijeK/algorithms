package training.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class LetterCombinationsOfAPhoneNumber {
    Map<Integer, List<Character>> MAPPING = Map.of(
            2, List.of('a', 'b', 'c'),
            3, List.of('d', 'e', 'f'),
            4, List.of('g', 'h', 'i'),
            5, List.of('j', 'k', 'l'),
            6, List.of('m', 'n', 'o'),
            7, List.of('p', 'q', 'r', 's'),
            8, List.of('t', 'u', 'v'),
            9, List.of('w', 'x', 'y', 'z')
    );


    // https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
    // Time Complexity: O(4^n)
    // Space Complexity: O(4^n)
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        backtrack(digits, 0, new StringBuilder(), combinations);

        return combinations;
    }


    private void backtrack(String digits, int index, StringBuilder currentCombination, List<String> combinations) {
        if (index == digits.length()) {
            combinations.add(currentCombination.toString());
            return;
        }

        int digit = digits.charAt(index) - '0';
        for (char character : MAPPING.get(digit)) {
            currentCombination.append(character);
            backtrack(digits, index + 1, currentCombination, combinations);
            currentCombination.setLength(currentCombination.length() - 1);
        }
    }
}
