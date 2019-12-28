package local.algorithm.leetcode;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.util.List;

import static local.algorithm.leetcode.NTreePreOrder.Node;
import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2019-12-27
 **/
public class NTreePreOrderTest {

    @Test
    public void testPreorder() {
        Node root = new Node(1);
        Node child1 = new Node(3, Lists.newArrayList(new Node(5), new Node(6)));
        root.children = Lists.newArrayList(child1, new Node(2), new Node(4));

        List<Integer> result = new NTreePreOrder().preorder(root);
        assertEquals(result, Lists.newArrayList(1, 3, 5, 6, 2, 4));
    }
}