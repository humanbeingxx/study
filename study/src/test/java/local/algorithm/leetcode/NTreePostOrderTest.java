package local.algorithm.leetcode;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/29 15:29
 */
public class NTreePostOrderTest {

    @Test
    public void testPostorder() {
        NTreePreOrder.Node root = new NTreePreOrder.Node(1);
        NTreePreOrder.Node child1 = new NTreePreOrder.Node(3, Lists.newArrayList(new NTreePreOrder.Node(5), new NTreePreOrder.Node(6)));
        root.children = Lists.newArrayList(child1, new NTreePreOrder.Node(2), new NTreePreOrder.Node(4));

        List<Integer> result = new NTreePostOrder().postorder(root);
        assertEquals(result, Lists.newArrayList(5,6,3,2,4,1));
    }
}