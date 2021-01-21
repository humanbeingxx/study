package local.interview_internal_reference.byhunter;

import java.util.Stack;

public class MaxStack {

    int max = Integer.MIN_VALUE;
    Stack<Integer> stack = new Stack<>();

    public void push(int val) {
        stack.push(max);
        if (val >= max) {
            max = val;
        }
        stack.push(val);
    }

    public int pop() {
        int val = stack.pop();
        max = stack.pop();
        return val;
    }

    public int max() {
        return max;
    }
}
