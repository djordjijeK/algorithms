package _2024.september;

import java.util.ArrayList;
import java.util.List;


public class LexicographicalNumbers {
    // https://leetcode.com/problems/lexicographical-numbers/editorial/
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>(n);

        for (int i = 1; i <= 9; i++) {
            generateLexicalNumbers(i, n, result);
        }

        return result;
    }


    private void generateLexicalNumbers(int number, int limit, List<Integer> result) {
        if (number > limit) {
            return;
        }

        result.add(number);

        for (int nextDigit = 0; nextDigit <= 9; nextDigit++) {
            int nextNumber = number * 10 + nextDigit;
            if (nextNumber <= limit) {
                generateLexicalNumbers(nextNumber, limit, result);
            } else {
                break;
            }
        }
    }
}
