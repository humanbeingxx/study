package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences2 {

    static class Node {
        char c;
        Node[] children = new Node[26];

        public Node(char c) {
            this.c = c;
        }

        public static Node initWith(char[] chars) {
            Node root = new Node(' ');
            Node node = root;
            for (int i = 0; i < 10; i++) {
                char c = chars[i];
                node.children[c - 'A'] = new Node(c);
                node = node.children[c - 'A'];
            }
            return root;
        }

        public boolean contains(char[] chars, int start) {
            Node node = this;
            for (int i = 0; i < 10; i++) {
                char c = chars[start + i];
                node = node.children[c - 'A'];
                if (node == null) {
                    return false;
                }
            }
            return true;
        }

        public void insert(char[] chars, int start) {
            Node node = this;
            for (int i = 0; i < 10; i++) {
                char c = chars[i + start];
                if (node.children[c - 'A'] == null) {
                    node.children[c - 'A'] = new Node(c);
                }
                node = node.children[c - 'A'];
            }
        }
    }

    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() <= 10) {
            return new ArrayList<>();
        }
        Set<String> result = new HashSet<>();
        char[] chars = s.toCharArray();
        Node root = Node.initWith(chars);
        for (int i = 1; i <= s.length() - 10; i++) {
            if (root.contains(chars, i)) {
                result.add(new String(chars, i, 10));
            } else {
                root.insert(chars, i);
            }
        }
        return new ArrayList<>(result);
    }
}
