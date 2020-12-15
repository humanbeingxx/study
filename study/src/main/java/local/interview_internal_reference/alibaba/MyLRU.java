package local.interview_internal_reference.alibaba;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/7/6 17:09
 */
public class MyLRU {

    class Node {
        int key;
        int val;
        Node pre;
        Node next;
    }

    private int capacity;
    private Node head;
    private Node tail;
    private Map<Integer, Node> cache;

    public MyLRU(int capacity) {
        Queue<Object> objects = new LinkedList<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
        cache = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        used(node);
        return node.val;
    }

    public void put(int key, int val) {
        if (val < 0) {
            return;
        }
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val = val;
            used(node);
        } else {
            Node node = new Node();
            node.key = key;
            node.val = val;
            tail.pre.next = node;
            node.pre = tail.pre;
            node.next = tail;
            tail.pre = node;
            cache.put(key, node);
        }
        if (cache.size() > capacity) {
            Node removeNode = head.next;
            head.next = head.next.next;
            head.next.pre = head;
            cache.remove(removeNode.key);
        }
    }

    private void used(Node node) {
        if (node.next == tail) {
            return;
        }
        Node pre = node.pre;
        Node next = node.next;

        pre.next = next;
        next.pre = pre;

        node.pre = tail.pre;
        node.next = tail;

        tail.pre.next = node;
        tail.pre = node;
    }
}
