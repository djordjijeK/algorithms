package training.graph.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


public class WordLadder {

    // https://leetcode.com/problems/word-ladder/description/
    // Time Complexity: O(n^2 * m)
    // Space Complexity: O(n * m)
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        wordList.add(beginWord);

        Map<String, List<String>> dictionary = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String pattern = word.substring(0, i) + '*' + word.substring(i + 1);
                dictionary.computeIfAbsent(pattern, key -> new ArrayList<>()).add(word);
            }
        }

        int pathLength = 1;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                String word = queue.poll();

                if (word.equals(endWord)) {
                    return pathLength;
                }

                for (int j = 0; j < word.length(); j++) {
                    String pattern = word.substring(0, j) + '*' + word.substring(j + 1);

                    for (String nextWord : dictionary.getOrDefault(pattern, List.of())) {
                        if (!visited.contains(nextWord)) {
                            queue.add(nextWord);
                            visited.add(nextWord);
                        }
                    }
                }
            }

            pathLength += 1;
        }

        return 0;
    }

}
