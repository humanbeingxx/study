package local.algorithm.leetcode.lcof;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxQueue {

    private Queue<Integer> dataQueue;
    private Deque<Integer> maxDeque;

    public MaxQueue() {
        dataQueue = new LinkedList<>();
        maxDeque = new LinkedList<>();
    }

    public int max_value() {
        return maxDeque.size() == 0 ? -1 : maxDeque.getFirst();
    }

    public void push_back(int value) {
        dataQueue.add(value);
        while (!maxDeque.isEmpty() && maxDeque.peekLast() < value) {
            maxDeque.removeLast();
        }
        maxDeque.addLast(value);
    }

    public int pop_front() {
        if (dataQueue.size() == 0) {
            return -1;
        }
        Integer val = dataQueue.poll();
        if (maxDeque.getFirst().equals(val)) {
            maxDeque.removeFirst();
        }
        return val;
    }
}
