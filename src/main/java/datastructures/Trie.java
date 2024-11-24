package datastructures;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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


    public boolean wordExists(String word) {
        TrieNode node = searchString(word);

        return node != null && node.isEndOfWord;
    }


    public boolean prefixExists(String prefix) {
        return searchString(prefix) != null;
    }


    public List<String> findWordsWithPrefix(String prefix) {
        TrieNode root = searchString(prefix);
        if (root == null) {
            return List.of();
        }

        List<String> result = new ArrayList<>();
        searchStringsWithPrefix(root, new StringBuilder(prefix), result);

        return result;
    }


    public void delete(String word) {
        delete(this.root, word, 0);
    }


    private TrieNode searchString(String string) {
        TrieNode current = this.root;
        for (char character : string.toCharArray()) {
            current = current.children.get(character);

            if (current == null) {
                return null;
            }
        }

        return current;
    }


    private void searchStringsWithPrefix(TrieNode current, StringBuilder prefix, List<String> result) {
        if (current.isEndOfWord) {
            result.add(prefix.toString());
        }

        for (Map.Entry<Character, TrieNode> entry : current.children.entrySet()) {
            prefix.append(entry.getKey());
            searchStringsWithPrefix(entry.getValue(), prefix, result);
            prefix.setLength(prefix.length() - 1);
        }
    }


    private boolean delete(TrieNode current, String word, int index) {
        if (word.length() == index) {
            if (!current.isEndOfWord) {
                return false;
            }

            current.isEndOfWord = false;
            return current.children.isEmpty();
        }

        char character = word.charAt(index);
        TrieNode node = current.children.get(character);
        if (node == null) {
            return false;
        }

        boolean shouldBeDeleted = delete(node, word, index + 1);
        if (shouldBeDeleted) {
            current.children.remove(character);
            return current.children.isEmpty() && !current.isEndOfWord;
        }

        return false;
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
