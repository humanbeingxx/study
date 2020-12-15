package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static local.algorithm.leetcode.FlattenLevelNode.Node;

public class FlattenLevelNodeTest {

    @Test
    public void testFlatten() {
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node12 = new Node(12);
        head.next = node2;
        node2.prev = head;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;
        node4.next = node5;
        node5.prev = node4;
        node5.next = node6;
        node6.prev = node5;

        node3.child = node7;
        node7.next = node8;
        node8.prev = node7;
        node8.next = node9;
        node9.prev = node8;
        node9.next = node10;
        node10.prev = node9;

        node8.child = node11;
        node11.next = node12;
        node12.prev = node11;

        head = new FlattenLevelNode().flatten(head);
        System.out.println(new FlattenLevelNode().show(head));
    }

    @Test
    public void test() {
        Node head = new Node(1);
        head = new FlattenLevelNode().flatten(head);
        System.out.println(new FlattenLevelNode().show(head));
    }
}