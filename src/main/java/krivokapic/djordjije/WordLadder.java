package krivokapic.djordjije;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;


// https://leetcode.com/problems/word-ladder/description
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> bagOfWords = new HashSet<>(wordList);

        if (!bagOfWords.contains(endWord)) {
            return 0;
        }

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        Queue<Tuple> queue = new ArrayDeque<>();
        queue.offer(new Tuple(beginWord, 0));

        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();

            String currentWord = tuple.word;
            int transitions = tuple.transitions;

            if (currentWord.equals(endWord)) {
                return transitions + 1;
            }

            for (String word : bagOfWords) {
                if (isOneDistance(word, currentWord) && !visited.contains(word)) {
                    queue.offer(new Tuple(word, transitions + 1));
                    visited.add(word);
                }
            }
        }

        return 0;
    }

    record Tuple(String word, int transitions) {}

    boolean isOneDistance(String fist, String second) {
        int differences = 0;
        for (int index = 0; index < fist.length(); index++) {
            if (fist.charAt(index) != second.charAt(index)) {
                differences += 1;
            }
        }

        return differences == 1;
    }
}
