package local.algorithm.leetcode;

public class MyLinkedList {

    private class Node {
        int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node dummyHead;
    private Node head;
    private Node tail;
    int size = 0;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        dummyHead = new Node(0);
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index >= size) {
            return -1;
        }
        Node node = head;
        while (index > 0) {
            node = node.next;
            index--;
        }
        return node.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = dummyHead.next;
        dummyHead.next = newNode;
        head = newNode;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (tail == null) {
            addAtHead(val);
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index <= 0) {
            addAtHead(val);
            return;
        } else if (index == size) {
            addAtTail(val);
            return;
        }
        Node pre = null, node = head;
        while (index > 0) {
            pre = node;
            node = node.next;
            index--;
        }
        Node newNode = new Node(val);
        newNode.next = node;
        pre.next = newNode;
        size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (size == 1) {
            dummyHead.next = null;
            head = null;
            tail = null;
            size = 0;
            return;
        }
        Node pre = dummyHead, node = head;
        while (index > 0) {
            pre = node;
            node = node.next;
            index--;
        }
        if (node == head) {
            dummyHead.next = node.next;
            head = node.next;
        } else if (node == tail) {
            pre.next = null;
            tail = pre;
        } else {
            pre.next = node.next;
        }
        size--;
    }

    public String display() {
        Node node = head;
        StringBuilder stringBuilder = new StringBuilder();
        while (node != null) {
            stringBuilder.append(node.val).append("->");
            node = node.next;
        }
        return stringBuilder.toString();
    }
}
