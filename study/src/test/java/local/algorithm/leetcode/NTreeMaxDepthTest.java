package local.algorithm.leetcode;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import static local.algorithm.leetcode.NTreePreOrder.Node;
import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-01-03
 **/
public class NTreeMaxDepthTest {

    @Test
    public void testMaxDepth() {
        Node root = new Node(1);
        Node child1 = new Node(3, Lists.newArrayList(new Node(5), new Node(6)));
        root.children = Lists.newArrayList(child1, new Node(2), new Node(4));

        int result = new NTreeMaxDepth().maxDepth(root);
        assertEquals(result, 3);

    }
}