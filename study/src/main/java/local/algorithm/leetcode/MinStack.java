package local.algorithm.leetcode;

import java.util.Stack;

/**
 * @author cuixiaoshuang
 * @date 2019-12-19
 **/
public class MinStack {

    int min;
    Stack<Integer> stack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        min = Integer.MAX_VALUE;
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(min);
        if (x < min) {
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        stack.pop();
        min = stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
