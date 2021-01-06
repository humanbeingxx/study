package local.algorithm.leetcode;

import local.algorithm.leetcode.NTreePreOrder.Node;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2020-02-21
 **/
public class NTreeLevelOrderTest {

    @Test
    public void testLevelOrder() {
        Node root = new Node(1);
        root.children = new ArrayList<>();
        Node node2 = new Node(2);
        root.children.add(node2);
        root.children.add(new Node(3));
        root.children.add(new Node(4));
        node2.children = new ArrayList<>();
        node2.children.add(new Node(5));
        node2.children.add(new Node(6));
        List<List<Integer>> result = new NTreeLevelOrder().levelOrder(root);
        result.forEach(System.out::println);
    }
}