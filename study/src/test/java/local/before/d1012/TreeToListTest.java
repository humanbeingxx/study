package local.before.d1012;

import com.google.common.collect.Lists;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author xiaoshuang.cui
 * @date 2018/10/12 下午8:55
 **/
public class TreeToListTest {

    @Test
    public void testBinaryTree() {
        BinaryTree tree = new BinaryTree();

        tree.add(5);
        tree.add(3);
        tree.add(1);
        tree.add(6);
        tree.add(4);
        tree.add(7);

        Assert.assertNotNull(tree.search(5));
        Assert.assertNotNull(tree.search(3));
        Assert.assertNotNull(tree.search(1));
        Assert.assertNotNull(tree.search(6));
        Assert.assertNotNull(tree.search(4));
        Assert.assertNotNull(tree.search(7));
        Assert.assertNull(tree.search(0));

        BinaryTree.Node head = tree.getHead();

        Assert.assertEquals(5, head.getData());
        Assert.assertEquals(3, head.getLeftChild().getData());
        Assert.assertEquals(6, head.getRightChild().getData());

        Assert.assertEquals(1, head.getLeftChild().getLeftChild().getData());
        Assert.assertEquals(4, head.getLeftChild().getRightChild().getData());

        Assert.assertEquals(7, head.getRightChild().getRightChild().getData());
    }

    @Test
    public void testList() {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Assert.assertEquals(list.toList(), Lists.newArrayList(1, 2, 3, 4, 5));

        LinkedList list2 = new LinkedList();
        Assert.assertEquals(list2.toList(), Lists.newArrayList());
    }

    @Test
    public void testTreeToList() {
        BinaryTree tree = new BinaryTree();

        tree.add(5);
        tree.add(3);
        tree.add(1);
        tree.add(6);
        tree.add(4);
        tree.add(7);

        LinkedList linkedList = tree.toList();

        Assert.assertEquals(linkedList.toList(), Lists.newArrayList(1, 3, 4, 5, 6, 7));

        BinaryTree tree2 = new BinaryTree();
        Assert.assertEquals(tree2.toList().toList(), Lists.newArrayList());

    }
}
