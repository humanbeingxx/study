package local.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cuixiaoshuang
 * @date 2020-02-12
 **/
public class CopyRandomList {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Integer> nodeIndex = new HashMap<>();
        Node node = head;
        int index = 0;
        while (node != null) {
            nodeIndex.put(node, index);
            node = node.next;
            index++;
        }

        node = head;
        int[] randoms = new int[index];
        index = 0;
        while (node != null) {
            Node random = node.random;
            if (random == null) {
                randoms[index] = -1;
            } else {
                randoms[index] = nodeIndex.get(random);
            }
            index++;
            node = node.next;
        }

        Node newHead = new Node(head.val), newNode = newHead;
        node = head.next;
        Node[] nodes = new Node[index];
        nodes[0] = newHead;
        index = 1;
        while (node != null) {
            nodes[index] = newNode;
            newHead.next = new Node(node.val);
            newNode = newNode.next;
            node = node.next;
            index++;
        }
        for (int i = 0; i < randoms.length; i++) {
            int random = randoms[i];
            if (random >= 0) {
                nodes[i].random = nodes[random];
            }
        }

        return newHead;
    }
}
