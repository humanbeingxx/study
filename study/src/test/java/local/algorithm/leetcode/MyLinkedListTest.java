package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MyLinkedListTest {

    @Test
    public void test() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);   //链表变为1-> 2-> 3
        assertEquals(linkedList.get(1), 2);            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        assertEquals(linkedList.get(1), 3);        //返回3
    }

    @Test
    public void testBoundary() {
        MyLinkedList list = new MyLinkedList();
        System.out.println(list.display());
        list.deleteAtIndex(0);
        System.out.println(list.display());
        list.addAtTail(1);
        System.out.println(list.display());
        list.addAtTail(2);
        System.out.println(list.display());
        list.deleteAtIndex(0);
        System.out.println(list.display());
        list.addAtHead(1);
        System.out.println(list.display());
        list.deleteAtIndex(1);
        System.out.println(list.display());
    }
}