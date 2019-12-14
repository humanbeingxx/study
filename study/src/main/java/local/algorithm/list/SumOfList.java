package local.algorithm.list;

/**
 * @author cuixiaoshuang
 * @date 2019-12-13
 **/
public class SumOfList {

    public static MyLinkedList sum(MyLinkedList list1, MyLinkedList list2) {
        int flowOver = 0;
        int left = 0;
        MyLinkedList.Node node1 = list1.head.next;
        MyLinkedList.Node node2 = list2.head.next;
        MyLinkedList result = new MyLinkedList();
        while (node1 != null || node2 != null) {
            int value = flowOver;

            if (node1 != null) {
                value += node1.data;
                node1 = node1.next;
            }
            if (node2 != null) {
                value += node2.data;
                node2 = node2.next;
            }

            flowOver = value / 10;
            left = value % 10;
            result.add(new MyLinkedList.Node(left));
        }
        return result;
    }

    public static void main(String[] args) {
        MyLinkedList list1 = new MyLinkedList();
        list1.add(new MyLinkedList.Node(2));
        list1.add(new MyLinkedList.Node(4));
        list1.add(new MyLinkedList.Node(3));
        MyLinkedList list2 = new MyLinkedList();
        list2.add(new MyLinkedList.Node(5));
        list2.add(new MyLinkedList.Node(6));
        list2.add(new MyLinkedList.Node(4));
        System.out.println(sum(
                list1,
                list2
        ));
    }
}
