package local.algorithm.list;

/**
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

    public void reverse2() {
        if (head.next == null) {
            return;
        }

        Node next = head.next;
        Node nnext = head.next.next;
        next.next = null;
        reverseRec2(next, nnext);
    }

    private void reverseRec2(Node next, Node nnext) {
        head.next = next;
        if (nnext == null) {
            return;
        }
        System.out.println(next.data + " - " + nnext.data);

        Node newNNext = nnext.next;
        nnext.next = next;
        reverseRec2(nnext, newNNext);
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
