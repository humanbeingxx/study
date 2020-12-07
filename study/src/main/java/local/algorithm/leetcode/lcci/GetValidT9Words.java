package local.algorithm.leetcode.lcci;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetValidT9Words {

    private final char[][] mapping = new char['9' + 1][];

    {
        mapping['2'] = new char[]{'a', 'a' + 1, 'a' + 2};
        mapping['3'] = new char[]{'a' + 3, 'a' + 4, 'a' + 5};
        mapping['4'] = new char[]{'a' + 6, 'a' + 7, 'a' + 8};
        mapping['5'] = new char[]{'a' + 9, 'a' + 10, 'a' + 11};
        mapping['6'] = new char[]{'a' + 12, 'a' + 13, 'a' + 14};
        mapping['7'] = new char[]{'a' + 15, 'a' + 16, 'a' + 17, 'a' + 18};
        mapping['8'] = new char[]{'a' + 19, 'a' + 20, 'a' + 21};
        mapping['9'] = new char[]{'a' + 22, 'a' + 23, 'a' + 24, 'a' + 25};
    }

    class Node {
        char c;
        Map<Character, Node> children = new HashMap<>();
        boolean isWord = false;

        public Node(char c) {
            this.c = c;
        }
    }

    public List<String> getValidT9Words(String num, String[] words) {
        Node root = buildTree(words);
        List<String> result = new ArrayList<>();
        StringBuilder tempStr = new StringBuilder();
        checkNumInTree(num, 0, root, tempStr, result);
        return result;
    }

    private void checkNumInTree(String num, int numIndex, Node currNode, StringBuilder tempStr, List<String> result) {
        if (currNode == null) {
            return;
        }
        if (numIndex == num.length()) {
            if (currNode.isWord) {
                result.add(tempStr.toString());
            }
            return;
        }
        char[] mapChars = mapping[num.charAt(numIndex)];
        for (char mapChar : mapChars) {
            if (currNode.children.containsKey(mapChar)) {
                tempStr.append(mapChar);
                checkNumInTree(num, numIndex + 1, currNode.children.get(mapChar), tempStr, result);
                tempStr.deleteCharAt(tempStr.length() - 1);
            }
        }
    }

    Node buildTree(String[] words) {
        Node root = new Node((char) 0);
        for (String word : words) {
            addWord(word, root);
        }
        return root;
    }

    private void addWord(String word, Node root) {
        if (word == null || word.isEmpty()) {
            return;
        }
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Node child = node.children.get(c);
            if (child == null) {
                Node newNode = new Node(c);
                node.children.put(c, newNode);
                node = newNode;
            } else {
                node = node.children.get(c);
            }
        }
        node.isWord = true;
    }
}
