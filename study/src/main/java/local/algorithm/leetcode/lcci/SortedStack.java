package local.algorithm.leetcode.lcci;

import java.util.Stack;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/21 19:59
 */
public class SortedStack {

    private Stack<Integer> data;
    private Stack<Integer> temp;

    public SortedStack() {
        data = new Stack<>();
        temp = new Stack<>();
    }

    public void push(int val) {
        if (data.isEmpty() || val < data.peek()) {
            data.push(val);
        } else {
            while (!data.isEmpty()) {
                Integer peek = data.peek();
                if (peek < val) {
                    temp.push(data.pop());
                } else {
                    break;
                }
            }
            data.push(val);
            while (!temp.isEmpty()) {
                data.push(temp.pop());
            }
        }
    }

    public void pop() {
        if (!data.isEmpty()) {
            data.pop();
        }
    }

    public int peek() {
        if (data.isEmpty()) {
            return -1;
        }
        return data.peek();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }
}
