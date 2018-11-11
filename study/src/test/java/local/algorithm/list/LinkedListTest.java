package local.algorithm.list;

import org.testng.annotations.Test;

/**
 * @author xiaoshuang.cui
 * @date 2018/8/30 下午5:07
 **/
public class LinkedListTest {

    @Test
    public void testAdd() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(new LinkedList.Node(1));
        linkedList.add(new LinkedList.Node(2));
        linkedList.add(new LinkedList.Node(3));
        linkedList.add(new LinkedList.Node(4));

        System.out.println(linkedList);
    }

    @Test
    public void testreverse2() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(new LinkedList.Node(1));
        linkedList.add(new LinkedList.Node(2));
        linkedList.add(new LinkedList.Node(3));
        linkedList.add(new LinkedList.Node(4));

        linkedList.reverse2();

        System.out.println(linkedList);
    }

    @Test
    public void testReverse2() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(new LinkedList.Node(1));

        linkedList.reverse2();

        System.out.println(linkedList);
    }

    @Test
    public void testAll() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(new LinkedList.Node(1));
        linkedList.add(new LinkedList.Node(2));
        linkedList.add(new LinkedList.Node(3));
        linkedList.add(new LinkedList.Node(4));

        linkedList.reverse2();

        linkedList.add(new LinkedList.Node(1));
        linkedList.add(new LinkedList.Node(2));
        linkedList.add(new LinkedList.Node(3));
        linkedList.add(new LinkedList.Node(4));

        System.out.println(linkedList);

        linkedList.reverse2();
        System.out.println(linkedList);
    }
}