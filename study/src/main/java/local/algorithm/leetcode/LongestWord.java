package local.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/21 19:52
 */
public class LongestWord {

    public static class Node {
        Character c;
        int count = 0;
        boolean isEnd = false;
        Map<Character, Node> next = new HashMap<>();

        public Node(Character c) {
            this.c = c;
        }
    }

    public String longestWord(String[] words) {
        Node root = constructTree(words);
        Arrays.sort(words);
        String longest = null;
        for (int i = words.length - 1; i >= 0; i--) {
            if (check(root, words[i])) {
                if (longest == null || longest.length() <= words[i].length()) {
                    longest = words[i];
                }
            }

        }
        return longest;
    }

    boolean check(Node node, String word) {
        while (node != null && word.length() > 0) {
            if (!node.isEnd) {
                return false;
            }
            if (!node.next.containsKey(word.charAt(0))) {
                return false;
            }
            node = node.next.get(word.charAt(0));
            word = word.substring(1);
        }

        return true;
    }

    Node constructTree(String[] words) {
        Node root = new Node('-');
        root.isEnd = true;
        for (String word : words) {
            constructOne(root, word);
        }
        return root;
    }

    void constructOne(Node root, String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (!node.next.containsKey(c)) {
                Node value = new Node(c);
                value.count = 1;
                node.next.put(c, value);
            } else {
                node.next.get(c).count++;
            }
            node = node.next.get(c);
        }
        node.isEnd = true;
    }
}
