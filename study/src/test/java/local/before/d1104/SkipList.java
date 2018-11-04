package local.before.d1104;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Random;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/4 16:54
 */
public class SkipList<K extends Comparable<K>, V> {

    private final static int MAX_LEVEL = 5;

    private final static Random RANDOM = new Random();

    private final static int[] CHANCES = new int[MAX_LEVEL];

    static {
        for (int i = 0; i < MAX_LEVEL; i++) {
            CHANCES[i] = (int) Math.pow(2, i);
        }
    }

    private List<Node<K, V>> heads = Lists.newArrayListWithExpectedSize(MAX_LEVEL);

    public SkipList() {
        for (int i = 0; i < MAX_LEVEL; i++) {
            Node<K, V> node = new Node<>(null, null);
            heads.add(node);
            if (i >= 1) {
                node.down = heads.get(i - 1);
            }
        }
    }

    public void add(K key, V value) {
        Preconditions.checkArgument(key != null);
        Preconditions.checkArgument(value != null);

        Node<K, V> levelNode;
        Node<K, V> lowLevelNode = null;
        for (int i = 0; i < MAX_LEVEL; i++) {
            if (needUp(i)) {
                levelNode = new Node<>(key, value);
                insertOneLine(levelNode, heads.get(i));
                levelNode.down = lowLevelNode;
                lowLevelNode = levelNode;
            }
        }
    }

    private void insertOneLine(Node<K, V> newNode, Node<K, V> head) {
        if (head.next == null) {
            head.next = newNode;
            return;
        }
        Node<K, V> pre = head;
        Node<K, V> cur = head.next;


        while (cur != null && cur.key.compareTo(newNode.key) <= 0) {
            pre = cur;
            cur = cur.next;
        }

        pre.next = newNode;
        if (cur != null) {
            newNode.next = cur;
        }
    }

    private boolean needUp(int level) {
        return RANDOM.nextInt(CHANCES[level]) == 0;
    }

    public V search(K key) {
        Preconditions.checkArgument(key != null);

        Node<K, V> beginNode = null;
        for (int i = MAX_LEVEL - 1; i >= 0; i--) {
            if (beginNode == null) {
                beginNode = heads.get(i);
            } else {
                beginNode = beginNode.down;
            }
            Node<K, V> search = searchInOneLine(key, beginNode);
            if (search != heads.get(i) && search.key.compareTo(key) == 0) {
                return search.value;
            }
        }
        return null;
    }

    private Node<K, V> searchInOneLine(K key, Node<K, V> head) {
        if (head.next == null) {
            return head;
        }
        Node<K, V> node = head.next;
        Node<K, V> pre = node;
        while (node != null) {
            if (node.key.compareTo(key) < 0) {
                pre = node;
            }
            if (node.key.compareTo(key) == 0) {
                return node;
            }
            node = node.next;
        }
        return pre;
    }

    public static class Node<K extends Comparable<K>, V> {
        private K key;
        private V value;
        private Node<K, V> next;
        private Node<K, V> down;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", next=" + next +
                    '}';
        }
    }
}
