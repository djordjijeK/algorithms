package trie;

import java.util.HashMap;
import java.util.Map;


// https://leetcode.com/problems/implement-trie-prefix-tree/description/
public class Trie {
    private final TrieNode root;


    public Trie() {
        this.root = TrieNode.create();
    }


    public void insert(String word) {
        TrieNode current = this.root;

        for (char character : word.toCharArray()) {
            current = current.children.computeIfAbsent(character, ch -> TrieNode.create());
        }

        current.isEndOfWord = true;
    }


    public boolean search(String word) {
        TrieNode node = searchWord(word);

        return node != null && node.isEndOfWord;
    }


    public boolean startsWith(String prefix) {
        return searchWord(prefix) != null;
    }


    public TrieNode searchWord(String word) {
        TrieNode current = root;
        for (char character : word.toCharArray()) {
            current = current.children.get(character);
            if (current == null) {
                return null;
            }
        }

        return current;
    }


    private static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord;


        public static TrieNode create() {
            TrieNode trieNode = new TrieNode();

            trieNode.children = new HashMap<>();
            trieNode.isEndOfWord = false;

            return trieNode;
        }
    }
}
