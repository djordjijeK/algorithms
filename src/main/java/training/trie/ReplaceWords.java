package training.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class ReplaceWords {
    // https://leetcode.com/problems/replace-words/description/
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] bagOfWords = sentence.split(" ");
        Map<String, String> wordToShortestRoot = new HashMap<>();

        Trie trie = new Trie();
        for (String word : bagOfWords) {
            trie.insert(word);
        }

        for (String dictionaryWord : dictionary) {
            List<String> words = trie.findWordsWithPrefix(dictionaryWord);

            for (String word : words) {
                String root = wordToShortestRoot.get(word);
                if (root == null) {
                    wordToShortestRoot.put(word, dictionaryWord);
                } else if (root.length() > dictionaryWord.length()) {
                    wordToShortestRoot.put(word, dictionaryWord);
                }
            }
        }

        return Arrays.stream(bagOfWords)
            .map(word -> {
                if (wordToShortestRoot.containsKey(word)) {
                    return wordToShortestRoot.get(word);
                }

                return word;
            }).collect(Collectors.joining(" "));
    }


    private static class Trie {
        private static class TrieNode {
            TrieNode[] nodes = new TrieNode[26];
            String word = null;
        }


        private final TrieNode root;


        public Trie() {
            this.root = new TrieNode();
        }


        public void insert(String word) {
            TrieNode current = root;

            for (char c : word.toCharArray()) {
                int index = c - 'a';

                if (current.nodes[index] == null) {
                    current.nodes[index] = new TrieNode();
                }

                current = current.nodes[index];
            }

            current.word = word;
        }


        public List<String> findWordsWithPrefix(String prefix) {
            TrieNode current = findPrefix(prefix);
            if (current == null) {
                return List.of();
            }

            List<String> result = new ArrayList<>();
            dfs(current, new StringBuilder(prefix), result);

            return result;
        }


        private TrieNode findPrefix(String prefix) {
            TrieNode current = this.root;

            for (char c : prefix.toCharArray()) {
                int index = c - 'a';

                if (current.nodes[index] == null) {
                    return null;
                }

                current = current.nodes[index];
            }

            return current;
        }


        private void dfs(TrieNode current, StringBuilder stringBuilder, List<String> result) {
            if (current.word != null) {
                result.add(stringBuilder.toString());
            }

            for (int i = 0; i < current.nodes.length; i++) {
                if (current.nodes[i] == null) {
                    continue;
                }

                stringBuilder.append((char) (i + 'a'));
                dfs(current.nodes[i], stringBuilder, result);
                stringBuilder.setLength(stringBuilder.length() - 1);
            }
        }
    }
}
