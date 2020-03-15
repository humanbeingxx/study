package local.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    Queue<Integer> queue;
    Queue<Integer> queueTemp;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
        queueTemp = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queueTemp.add(x);
        while (!queue.isEmpty()) {
            queueTemp.add(queue.poll());
        }
        Queue<Integer> temp = queue;
        queue = queueTemp;
        queueTemp = temp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
