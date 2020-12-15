package local.algorithm.leetcode.lcci;

import java.util.HashMap;
import java.util.Map;

public class WordsFrequency {

    private class Node {
        char c;
        Map<Character, Node> children = new HashMap<>();
        int wordCount = 0;

        public Node(char c) {
            this.c = c;
        }
    }

    private Node tree;

    public WordsFrequency(String[] book) {
        tree = buildTree(book);
    }

    private Node buildTree(String[] words) {
        Node root = new Node((char) 0);
        for (String word : words) {
            if (word.length() == 0) {
                continue;
            }
            Node node = root;
            char[] charArray = word.toCharArray();
            for (char c : charArray) {
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new Node(c));
                }
                node = node.children.get(c);
            }
            node.wordCount++;
        }
        return root;
    }

    private int search(String word) {
        Node node = tree;
        char[] charArray = word.toCharArray();
        int count = 0;
        for (char c : charArray) {
            if (!node.children.containsKey(c)) {
                return 0;
            }
            node = node.children.get(c);
            count = node.wordCount;
        }
        return count;
    }

    public int get(String word) {
        return search(word);
    }
}
