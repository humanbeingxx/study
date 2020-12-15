package local.algorithm.leetcode.lcof;

import java.util.HashMap;
import java.util.Map;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/11 16:57
 */
public class CopyRandomList {

    static class Node {
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
        Map<Node, Node> nodeMapping = new HashMap<>();
        Node node = head, newHead = new Node(node.val), newNode = newHead;
        nodeMapping.put(node, newNode);
        node = node.next;
        while (node != null) {
            newNode.next = new Node(node.val);
            nodeMapping.put(node, newNode.next);
            node = node.next;
            newNode = newNode.next;
        }

        node = head;
        newNode = newHead;
        while (node != null) {
            if (node.random != null) {
                newNode.random = nodeMapping.get(node.random);
            }
            node = node.next;
            newNode = newNode.next;
        }
        return newHead;

    }
}


