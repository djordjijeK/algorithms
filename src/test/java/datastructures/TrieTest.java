package datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TrieTest {
    private Trie trie;


    @BeforeEach
    void setUp() {
        trie = new Trie();
    }


    @Test
    void insertAndWordExists() {
        trie.insert("apple");

        assertTrue(trie.wordExists("apple"));

        assertFalse(trie.wordExists("app"));
        assertFalse(trie.wordExists("apples"));
    }


    @Test
    void prefixExists() {
        trie.insert("apple");

        assertTrue(trie.prefixExists("app"));
        assertTrue(trie.prefixExists("appl"));
        assertTrue(trie.prefixExists("apple"));

        assertFalse(trie.prefixExists("b"));
    }


    @Test
    void findWordsWithPrefix() {
        trie.insert("apple");
        trie.insert("app");
        trie.insert("apricot");
        trie.insert("banana");

        List<String> wordsWithApp = trie.findWordsWithPrefix("app");
        assertEquals(2, wordsWithApp.size());
        assertTrue(wordsWithApp.contains("apple"));
        assertTrue(wordsWithApp.contains("app"));

        List<String> wordsWithBan = trie.findWordsWithPrefix("ban");
        assertEquals(1, wordsWithBan.size());
        assertTrue(wordsWithBan.contains("banana"));

        List<String> wordsWithX = trie.findWordsWithPrefix("x");
        assertTrue(wordsWithX.isEmpty());
    }


    @Test
    void delete() {
        trie.insert("apple");
        trie.insert("app");
        trie.insert("apricot");

        assertTrue(trie.wordExists("apple"));
        trie.delete("apple");
        assertFalse(trie.wordExists("apple"));
        assertTrue(trie.wordExists("app"));
        assertTrue(trie.prefixExists("app"));

        trie.delete("app");
        assertFalse(trie.wordExists("app"));
        assertTrue(trie.prefixExists("apr"));
        assertTrue(trie.wordExists("apricot"));

        trie.delete("apricot");
        assertFalse(trie.prefixExists("a"));
    }


    @Test
    void deleteNonexistentWord() {
        trie.insert("apple");
        trie.delete("app");

        assertTrue(trie.wordExists("apple"));
    }


    @Test
    void insertEmptyString() {
        trie.insert("");

        assertTrue(trie.wordExists(""));
        assertFalse(trie.wordExists("a"));
    }


    @Test
    void caseSensitivity() {
        trie.insert("Apple");

        assertTrue(trie.wordExists("Apple"));
        assertFalse(trie.wordExists("apple"));
    }
}
