package local.algorithm.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class FrontMiddleBackQueue {

    private Deque<Integer> head = new LinkedList<>();
    private Deque<Integer> tail = new LinkedList<>();

    public FrontMiddleBackQueue() {

    }

    public void pushFront(int val) {
        if (head.size() > tail.size()) {
            tail.addFirst(head.pollLast());
        }
        head.addFirst(val);
    }

    public void pushMiddle(int val) {
        if (head.size() < tail.size()) {
            head.addLast(val);
        } else if (head.size() == tail.size()) {
            tail.addFirst(val);
        } else {
            tail.addFirst(head.pollLast());
            head.addLast(val);
        }
    }

    public void pushBack(int val) {
        if (tail.size() > head.size()) {
            head.addLast(tail.pollLast());
        }
        tail.addLast(val);
    }

    public int popFront() {
        int val = -1;
        if (!head.isEmpty()) {
            val = head.pollFirst();
            if (head.size() < tail.size()) {
                head.addLast(tail.pollFirst());
            }
        } else {
            if (!tail.isEmpty()) {
                val = tail.pollFirst();
            }
        }
        return val;
    }

    public int popMiddle() {
        if (head.isEmpty() && tail.isEmpty()) {
            return -1;
        }
        if (head.size() >= tail.size()) {
            return head.pollLast();
        }
        return tail.pollFirst();
    }

    public int popBack() {
        int val = -1;
        if (!tail.isEmpty()) {
            val = tail.pollLast();
            if (tail.size() < head.size()) {
                tail.addFirst(head.pollLast());
            }
        } else {
            if (!head.isEmpty()) {
                val = head.pollLast();
            }
        }
        return val;
    }
}
