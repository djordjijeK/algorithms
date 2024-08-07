package krivokapic.djordjije.trie;

import java.util.HashMap;
import java.util.Map;


// https://leetcode.com/problems/implement-trie-prefix-tree/description/
public class ImplementTrie {
    class Trie {
        private final TrieNode root;


        public Trie() {
            this.root = new TrieNode();
        }


        public void insert(String word) {
            TrieNode current = this.root;

            for (char character : word.toCharArray()) {
                current = current.children.computeIfAbsent(character, c -> new TrieNode());
            }

            current.isEndOfWord = true;
        }


        public boolean search(String word) {
            TrieNode current = this.root;

            for (char character : word.toCharArray()) {
                current = current.children.get(character);

                if (current == null) {
                    return false;
                }
            }

            return current.isEndOfWord;
        }


        public boolean startsWith(String prefix) {
            TrieNode current = this.root;

            for (char character : prefix.toCharArray()) {
                current = current.children.get(character);

                if (current == null) {
                    return false;
                }
            }

            return true;
        }
    }


    static class TrieNode {
        public Map<Character, TrieNode> children;
        public boolean isEndOfWord;


        TrieNode() {
            this.children = new HashMap<>();
            this.isEndOfWord = false;
        }
    }
}
