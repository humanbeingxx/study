package local.algorithm.leetcode;

import java.util.List;

public class ReplaceWords {

    static class Node {
        char c;
        Node[] children = new Node[26];
        boolean isWord;

        public Node(char c) {
            this.c = c;
        }

        public void insert(String word) {
            Node node = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new Node(c);
                }
                node = node.children[c - 'a'];
                if (node.isWord) {
                    return;
                }
            }
            node.isWord = true;
        }

        public String searchPrefix(String word) {
            Node node = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                node = node.children[c - 'a'];
                if (node != null && node.isWord) {
                    return word.substring(0, i + 1);
                } else if (node == null) {
                    break;
                }
            }
            if (node == null || !node.isWord) {
                return null;
            }
            return word;
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Node root = new Node(' ');
        for (String word : dictionary) {
            root.insert(word);
        }
        String[] split = sentence.split(" ");
        for (int i = 0; i < split.length; i++) {
            String prefix = root.searchPrefix(split[i]);
            if (prefix != null) {
                split[i] = prefix;
            }
        }
        return String.join(" ", split);
    }
}
