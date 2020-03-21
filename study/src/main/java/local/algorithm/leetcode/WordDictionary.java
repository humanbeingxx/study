package local.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {

    private class Node {
        char c;
        boolean isWord;
        Map<Character, Node> nextNodes = new HashMap<>();

        public Node(char c, boolean isWord) {
            this.c = c;
            this.isWord = isWord;
        }
    }

    private Node head;

    /** Initialize your data structure here. */
    public WordDictionary() {
        head = new Node((char) 0, false);
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }
        Map<Character, Node> nextNodes = head.nextNodes;
        Node nextNode = null;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            nextNode = nextNodes.get(c);
            if (nextNode != null) {
                nextNodes = nextNode.nextNodes;
            } else {
                nextNode = new Node(c, false);
                nextNodes.put(c, nextNode);
                nextNodes = nextNode.nextNodes;
            }
        }
        nextNode.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if (word == null || word.isEmpty()) {
            return true;
        }
        return searchRec(word,0, head.nextNodes);
    }

    private boolean searchRec(String word, int index, Map<Character, Node> nextNodes) {
        if (index == word.length()) {
            return false;
        }
        char c = word.charAt(index);
        if (c == '.') {
            for (Node nexNode : nextNodes.values()) {
                if (index == word.length() - 1) {
                    if (nexNode.isWord) {
                        return true;
                    }
                } else {
                    if (searchRec(word, index + 1, nexNode.nextNodes)) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            Node nextNode = nextNodes.get(c);
            if (nextNode == null) {
                return false;
            } else if (index == word.length() - 1) {
                return nextNode.isWord;
            } else {
                return searchRec(word, index + 1, nextNode.nextNodes);
            }
        }
    }
}
