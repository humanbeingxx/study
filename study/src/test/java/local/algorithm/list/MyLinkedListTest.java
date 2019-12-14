package local.algorithm.list;

import org.testng.annotations.Test;

/**
 * @author xiaoshuang.cui
 * @date 2018/8/30 下午5:07
 **/
public class MyLinkedListTest {

    @Test
    public void testAdd() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(new MyLinkedList.Node(1));
        myLinkedList.add(new MyLinkedList.Node(2));
        myLinkedList.add(new MyLinkedList.Node(3));
        myLinkedList.add(new MyLinkedList.Node(4));

        System.out.println(myLinkedList);
    }

    @Test
    public void testreverse2() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(new MyLinkedList.Node(1));
        myLinkedList.add(new MyLinkedList.Node(2));
        myLinkedList.add(new MyLinkedList.Node(3));
        myLinkedList.add(new MyLinkedList.Node(4));

        myLinkedList.reverse2();

        System.out.println(myLinkedList);
    }

    @Test
    public void testReverse2() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(new MyLinkedList.Node(1));

        myLinkedList.reverse2();

        System.out.println(myLinkedList);
    }

    @Test
    public void testAll() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(new MyLinkedList.Node(1));
        myLinkedList.add(new MyLinkedList.Node(2));
        myLinkedList.add(new MyLinkedList.Node(3));
        myLinkedList.add(new MyLinkedList.Node(4));

        myLinkedList.reverse2();

        myLinkedList.add(new MyLinkedList.Node(1));
        myLinkedList.add(new MyLinkedList.Node(2));
        myLinkedList.add(new MyLinkedList.Node(3));
        myLinkedList.add(new MyLinkedList.Node(4));

        System.out.println(myLinkedList);

        myLinkedList.reverse2();
        System.out.println(myLinkedList);
    }
}