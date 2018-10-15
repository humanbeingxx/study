package local.before.d1012;

import lombok.Data;
import org.testng.collections.Lists;

import java.util.List;

/**
 * @author xiaoshuang.cui
 * @date 2018/10/12 下午9:10
 **/
@Data
public class LinkedList {

    @Data
    public static class Node {
        private int data;
        private Node next;
    }

    private Node head = new Node();

    public void add(int data) {
        Node newNode = new Node();
        newNode.data = data;

        Node node = head;
        while (node.next != null) {
            node = node.next;
        }

        node.next = newNode;
    }

    public List<Integer> toList() {
        List<Integer> list = Lists.newArrayList();
        Node node = head;
        while (node.next != null) {
            list.add(node.next.data);
            node = node.next;
        }
        return list;
    }
}
