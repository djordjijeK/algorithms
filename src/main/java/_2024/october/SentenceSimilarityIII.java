package _2024.october;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;


public class SentenceSimilarityIII {
    // https://leetcode.com/problems/sentence-similarity-iii/editorial/
    // Time Complexity: O(n + m)
    // Space Complexity: O(n + m)
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        Deque<String> sentenceFirstDeque = new ArrayDeque<>(Arrays.asList(sentence1.split(" ")));
        Deque<String> sentenceSecondDeque = new ArrayDeque<>(Arrays.asList(sentence2.split(" ")));

        while (!sentenceFirstDeque.isEmpty() && !sentenceSecondDeque.isEmpty() &&
                sentenceFirstDeque.peekFirst().equals(sentenceSecondDeque.peekFirst())
        ) {
            sentenceFirstDeque.pollFirst();
            sentenceSecondDeque.pollFirst();
        }

        while (!sentenceFirstDeque.isEmpty() && !sentenceSecondDeque.isEmpty() &&
                sentenceFirstDeque.peekLast().equals(sentenceSecondDeque.peekLast())
        ) {
            sentenceFirstDeque.pollLast();
            sentenceSecondDeque.pollLast();
        }

        return sentenceFirstDeque.isEmpty() || sentenceSecondDeque.isEmpty();
    }
}
