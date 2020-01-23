package local.algorithm.leetcode;

import local.algorithm.leetcode.LongestWord.Node;

import java.util.*;

/**
 * @author cuixiaoshuang
 * @date 2020-01-23
 **/
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Node wordTree = constructTree(wordDict);
        Set<String> checked = new HashSet<>();
        return wordBreakRec(s, wordTree, checked);
    }

    private boolean wordBreakRec(String s, Node wordTree, Set<String> checked) {
        if (checked.contains(s)) {
            return false;
        }
        Node node = wordTree;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Node nextNode = node.next.get(c);
            if (nextNode == null) {
                return false;
            } else if (nextNode.isEnd) {
                boolean subBreak = wordBreakRec(s.substring(i + 1), wordTree, checked);
                if (subBreak) {
                    return true;
                } else {
                    checked.add(s);
                }
            }
            node = nextNode;
        }
        return node.isEnd;
    }

    private Node constructTree(List<String> words) {
        Node root = new Node('-');
        root.isEnd = true;
        for (String word : words) {
            constructOne(root, word);
        }
        return root;
    }

    private void constructOne(Node root, String word) {
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
