package local.algorithm.leetcode;

import java.util.HashMap;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/5/28 1:07
 */
public class MinimumLengthEncoding {

    class Node {
        char c = 0;
        HashMap<Character, Node> children = new HashMap<>();

        public Node() {
        }

        public Node(char c) {
            this.c = c;
        }
    }

    public int minimumLengthEncoding(String[] words) {
        Node tree = constructTree(words);
        return countTreeLen(tree);
    }

    Node constructTree(String[] words) {
        Node tree = new Node();
        for (String word : words) {
            Node node = tree;
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                if (node.children.containsKey(c)) {
                    node = node.children.get(c);
                } else {
                    node.children.put(c, new Node(c));
                    node = node.children.get(c);
                }
            }
        }

        return tree;
    }

    private int countTreeLen(Node tree) {
        int[] len = {0};
        for (Node node : tree.children.values()) {
            countLenRec(node, 0, len);
        }
        return len[0];
    }

    private void countLenRec(Node node, int preLen, int[] len) {
        if (node.children.isEmpty()) {
            len[0] += preLen + 2;
        } else {
            for (Node value : node.children.values()) {
                countLenRec(value, preLen + 1, len);
            }
        }
    }
}
