package local.algorithm;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }

    public static final ListNode EMPTY = new ListNode(0);

    public String display() {
        StringBuilder stringBuilder = new StringBuilder("ListNode: ");
        ListNode node = this;
        while (node != null) {
            stringBuilder.append(node.val).append(", ");
            node = node.next;
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 2);
        return stringBuilder.toString();
    }
}

