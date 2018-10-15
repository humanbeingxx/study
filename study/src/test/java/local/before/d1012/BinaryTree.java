package local.before.d1012;

import lombok.Data;

/**
 * @author xiaoshuang.cui
 * @date 2018/10/12 下午8:56
 **/
@Data
public class BinaryTree {

    @Data
    public static class Node {
        private int data;
        private Node leftChild;
        private Node rightChild;
    }

    private Node head;

    public void add(int data) {
        Node newNode = new Node();
        newNode.setData(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node parent = searchParent(head, data);
        if (parent.data >= data) {
            parent.leftChild = newNode;
        } else {
            parent.rightChild = newNode;
        }
    }

    private Node searchParent(Node currentNode, int data) {

        if (currentNode == null) {
            return null;
        }

        if (currentNode.data >= data) {
            if (currentNode.leftChild == null) {
                return currentNode;
            } else {
                return searchParent(currentNode.leftChild, data);
            }
        } else {
            if (currentNode.rightChild == null) {
                return currentNode;
            } else {
                return searchParent(currentNode.rightChild, data);
            }
        }
    }

    public Node search(int data) {
        return searchRec(head, data);
    }

    private Node searchRec(Node node, int data) {
        if (node == null) {
            return null;
        } else if (node.data == data) {
            return node;
        } else if (node.data > data) {
            return searchRec(node.leftChild, data);
        } else {
            return searchRec(node.rightChild, data);
        }
    }

    public LinkedList toList() {
        LinkedList list = new LinkedList();
        put2List(list, head);
        return list;
    }

    private void put2List(LinkedList list, Node node) {
        if (node == null) {
            return;
        }
        if (node.leftChild != null) {
            put2List(list, node.leftChild);
        }
        list.add(node.data);
        if (node.rightChild != null) {
            put2List(list, node.rightChild);
        }
    }
}
