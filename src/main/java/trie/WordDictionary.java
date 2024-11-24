package trie;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


// https://leetcode.com/problems/design-add-and-search-words-data-structure/description/
public class WordDictionary {
    private final Node root;


    public WordDictionary() {
        this.root = new Node();
    }


    public void addWord(String word) {
        Node current = this.root;

        for (char character : word.toCharArray()) {
            current = current.children.computeIfAbsent(character, ch -> new Node());
        }

        current.isEndOfWord = true;
    }


    public boolean search(String word) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(this.root);

        for (char character : word.toCharArray()) {
            int queueSize = queue.size();

            while (queueSize > 0) {
                Node node = queue.poll();

                if (character == '.') {
                    for (Node child : node.children.values()) {
                        queue.offer(child);
                    }
                } else {
                    if (node.children.containsKey(character)) {
                        queue.offer(node.children.get(character));
                    }
                }

                queueSize -= 1;
            }

            if (queue.isEmpty()) {
                return false;
            }
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.isEndOfWord) {
                return true;
            }
        }

        return false;
    }


    private static class Node {
        Map<Character, Node> children;
        boolean isEndOfWord;


        public Node() {
            this.children = new HashMap<>();
            this.isEndOfWord = false;
        }
    }
}
