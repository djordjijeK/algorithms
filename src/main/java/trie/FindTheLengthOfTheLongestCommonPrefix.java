package trie;

import java.util.HashMap;
import java.util.Map;


public class FindTheLengthOfTheLongestCommonPrefix {

    // https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix
    // Time Complexity: O(m*d + n*d), m - length of arr1, n - length of arr2
    // Space Complexity: O(m*d)
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie trie = new Trie();
        int result = 0;

        for (int integer : arr1) {
            trie.insert(String.valueOf(integer));
        }

        for (int integer : arr2) {
            result = Math.max(result, trie.prefixLength(String.valueOf(integer)));
        }

        return result;
    }

    static class Trie {
        TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public int prefixLength(String word) {
            TrieNode current = this.root;
            int prefixLength = 0;

            for (char character : word.toCharArray()) {
                current = current.children.get(character);
                if (current == null) {
                    break;
                }

                prefixLength++;
            }

            return prefixLength;
        }

        public void insert(String word) {
            TrieNode current = this.root;

            for (char character : word.toCharArray()) {
                current = current.children.computeIfAbsent(character, ch -> new TrieNode());
            }

            current.isEndOfWord = true;
        }

        static class TrieNode {
            final Map<Character, TrieNode> children;
            boolean isEndOfWord;

            public TrieNode() {
                this.children = new HashMap<>();
                this.isEndOfWord = false;
            }
        }
    }

}
