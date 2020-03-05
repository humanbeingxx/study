package local.algorithm;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class HuffmanCode {

    class Node {
        String val;
        int weight;
        Node left;
        Node right;

        public Node(String val, int weight) {
            this.val = val;
            this.weight = weight;
        }
    }

    public List<Pair<String, String>> encode(List<Pair<String, Integer>> words) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        for (Pair<String, Integer> word : words) {
            queue.add(new Node(word.getLeft(), word.getRight()));
        }
        Node root = buildTree(queue);
        Preconditions.checkNotNull(root);
        List<Pair<String, String>> codes = new ArrayList<>();
        buildCodes(root, new StringBuilder(), codes);
        return codes;
    }

    private Node buildTree(PriorityQueue<Node> queue) {
        while (!queue.isEmpty()) {
            if (queue.size() == 1) {
                return queue.poll();
            }
            Node min = queue.poll();
            Node secondMin = queue.poll();
            Node parent = new Node("", min.weight + secondMin.weight);
            parent.left = min;
            parent.right = secondMin;
            queue.add(parent);
        }
        return null;
    }

    private void buildCodes(Node root, StringBuilder stringBuilder, List<Pair<String, String>> codes) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            codes.add(Pair.of(root.val, stringBuilder.toString()));
            return;
        }
        if (root.left != null) {
            stringBuilder.append(0);
            buildCodes(root.left, stringBuilder, codes);
            stringBuilder.setLength(stringBuilder.length() - 1);
        }
        if (root.right != null) {
            stringBuilder.append(1);
            buildCodes(root.right, stringBuilder, codes);
            stringBuilder.setLength(stringBuilder.length() - 1);
        }
    }
}
