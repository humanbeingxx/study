package local.algorithm.list;

/**
 *
 * @author xiaoshuang.cui
 * @date 2018/8/30 下午5:02
 **/
public class LinkedList {

    public static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }

    private Node head;

    private Node tail;

    public LinkedList() {
        head = new Node(0);
        tail = head;
    }

    public void add(Node node) {
        tail.next = node;
        tail = node;
    }

    public void reverse() {
        if (head.next == null) {
            return;
        }

        Node newTail = head.next;
        head.next = tail;
        tail = newTail;
        reverseRec(newTail, newTail.next);
        tail.next = null;
    }

    private void reverseRec(Node current, Node next) {
        if (current == null || next == null) {
            return;
        }
        Node nnext = next.next;
        next.next = current;

        reverseRec(next, nnext);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("head->");
        Node index = head.next;
        while (index != null) {
            sb.append(index.toString()).append("->");
            index = index.next;
        }

        return sb.subSequence(0, sb.length() - 2).toString();
    }
}
