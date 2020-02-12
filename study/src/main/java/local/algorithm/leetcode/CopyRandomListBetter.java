package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-02-12
 **/
public class CopyRandomListBetter {

    class Node {
        int val;
        CopyRandomListBetter.Node next;
        CopyRandomListBetter.Node random;

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
        Node node = head, newNode;
        while (node != null) {
            newNode = new Node(node.val);
            newNode.next = node.next;
            node.next = newNode;
            node = newNode.next;
        }
        node = head;
        while (node != null) {
            newNode = node.next;
            if (node.random != null) {
                newNode.random = node.random.next;
            }
            node = node.next.next;
        }

        Node newHead = head.next;
        node = head;
        newNode = newHead;
        while (true) {
            node.next = newNode.next;
            if (node.next == null) {
                break;
            } else {
                newNode.next = node.next.next;
            }

            node = node.next;
            newNode = newNode.next;
        }

        return newHead;
    }
}
