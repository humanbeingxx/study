package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-27
 **/
public class Trie {

    static class Node {
        boolean isWord;
        char c;
        Node[] next = new Node[26];

        public Node(boolean isWord, char c) {
            this.isWord = isWord;
            this.c = c;
        }
    }

    Node root;

    public Trie() {
        root = new Node(true, (char) 0);
        root.isWord = true;
    }

    public void insert(String word) {
        if (word.isEmpty()) {
            return;
        }
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            boolean isLast = i == word.length() - 1;
            Node nextNode = node.next[c- 'a'];
            if (nextNode == null) {
                node.next[c- 'a'] = new Node(isLast, c);
                nextNode = node.next[c- 'a'];
            } else if (isLast) {
                nextNode.isWord = true;
            }
            node = nextNode;
        }
    }

    public boolean search(String word) {
        if (word.isEmpty()) {
            return true;
        }
        Node node = root, nextNode = null;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            nextNode = node.next[c- 'a'];
            if (nextNode == null) {
                return false;
            }
            node = nextNode;
        }
        return nextNode.isWord;
    }

    public boolean startsWith(String prefix) {
        if (prefix.isEmpty()) {
            return true;
        }
        Node node = root, nextNode;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            nextNode = node.next[c- 'a'];
            if (nextNode == null) {
                return false;
            }
            node = nextNode;
        }
        return true;
    }
}
