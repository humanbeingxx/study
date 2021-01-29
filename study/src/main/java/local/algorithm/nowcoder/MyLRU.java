package local.algorithm.nowcoder;

import com.google.common.base.Preconditions;

import java.util.HashMap;
import java.util.Map;

public class MyLRU<K, T> {

    static class Node<K, T> {
        K key;
        T val;
        Node<K, T> pre;
        Node<K, T> next;

        public Node(K key, T val) {
            this.key = key;
            this.val = val;
        }
    }

    int size;

    Map<K, Node<K, T>> cache = new HashMap<>();
    Node<K, T> head = new Node<>(null,null);
    Node<K, T> tail;

    public MyLRU(int size) {
        Preconditions.checkArgument(size >= 1);
        this.size = size;
    }

    public void put(K key, T val) {
        Node<K, T> newNode = new Node<>(key, val);
        cache.put(key, newNode);
        used(newNode);
        if (cache.size() > size) {
            cache.remove(head.next.key);
            head.next = head.next.next;
            head.next.pre = head;
        }
    }

    public T get(K key) {
        Node<K, T> tNode = cache.get(key);
        if (tNode == null) {
            return null;
        }
        used(tNode);
        return tNode.val;
    }

    private void used(Node<K, T> node) {
        if (head.next == null) {
            head.next = node;
            node.pre = head;
        } else {
            if (node.pre != null) {
                node.pre.next = node.next;
            }
            if (node.next != null) {
                node.next.pre = node.pre;
            }
            if (tail != null) {
                tail.next = node;
            }
        }
        node.next = null;
        tail = node;
    }
}
