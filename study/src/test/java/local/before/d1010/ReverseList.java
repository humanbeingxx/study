package local.before.d1010;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author xiaoshuang.cui
 * @date 2018/10/10 上午11:50
 **/
public class ReverseList {

    static class MyList {

        private Node header = new Node(0, null);

        public void add(Node newNode) {
            Node node = header;
            while (node.next != null) {
                node = node.next;
            }
            node.next = newNode;
        }

        public void reverse() {
            if (header.next == null || header.next.next == null) {
                return;
            }
            Node pre = header.next, cur = pre.next, nxt = cur.next;
            pre.next = null;

            while (cur.next != null) {
                cur.next = pre;
                pre = cur;
                cur = nxt;
                nxt = nxt.next;
            }
            cur.next = pre;
            header.next = cur;
        }

        public int count() {
            int count = 0;
            Node node = header.next;
            while (node != null) {
                node = node.next;
                count++;
            }
            return count;
        }

        public int[] toArray() {
            int[] array = new int[count()];
            Node node = header.next;
            int index = 0;
            while (node != null) {
                array[index++] = node.data;
                node = node.next;
            }
            return array;
        }

        static class Node {
            private int data;
            private Node next;

            public Node(int data, Node next) {
                this.data = data;
                this.next = next;
            }

            public int getData() {
                return data;
            }

            public void setData(int data) {
                this.data = data;
            }

            public Node getNext() {
                return next;
            }

            public void setNext(Node next) {
                this.next = next;
            }
        }
    }

    @Test
    public void testCount() {
        MyList myList = new MyList();
        Assert.assertEquals(myList.count(), 0);
    }

    @Test
    public void testAdd() {
        MyList myList = new MyList();
        myList.add(new MyList.Node(1, null));
        myList.add(new MyList.Node(2, null));
        myList.add(new MyList.Node(3, null));
        myList.add(new MyList.Node(4, null));
        myList.add(new MyList.Node(5, null));

        Assert.assertEquals(myList.count(), 5);
        Assert.assertEquals(myList.toArray(), new int[]{1, 2, 3, 4, 5});
    }

    @Test
    public void testReverse() {
        MyList myList = new MyList();
        myList.add(new MyList.Node(1, null));
        myList.add(new MyList.Node(2, null));
        myList.add(new MyList.Node(3, null));
        myList.add(new MyList.Node(4, null));
        myList.add(new MyList.Node(5, null));

        myList.reverse();

        Assert.assertEquals(myList.count(), 5);
        Assert.assertEquals(myList.toArray(), new int[]{5, 4, 3, 2, 1});
    }
}
