package core.trie;

import java.util.ArrayList;
import java.util.List;


public class WordSearchII {
    // https://leetcode.com/problems/word-search-ii/description/
    // Time Complexity: O(n * m * 4 ^ length of the longest word)
    // Space Complexity: O(n * length of the longest word)
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, root, i, j, result);
            }
        }

        return result;
    }


    private void dfs(char[][] board, TrieNode root, int i, int j, List<String> words) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }

        char character = board[i][j];
        if (character == '#' || root.children[character - 'a'] == null) {
            return;
        }

        root = root.children[character - 'a'];
        if (root.word != null) {
            words.add(root.word);
            root.word = null;
        }

        board[i][j] = '#';

        dfs(board, root, i - 1, j, words);
        dfs(board, root, i + 1, j, words);
        dfs(board, root, i, j - 1, words);
        dfs(board, root, i, j + 1, words);

        board[i][j] = character;
    }


    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode current = root;

            for (char character : word.toCharArray()) {
                int index = character - 'a';

                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }

                current = current.children[index];
            }

            current.word = word;
        }

        return root;
    }


    private static class TrieNode {
        TrieNode[] children;
        String word;


        public TrieNode() {
            this.children = new TrieNode[26];
            this.word = null;
        }
    }
}
