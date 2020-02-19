package local.algorithm.leetcode;

import java.util.Stack;

/**
 * @author cuixiaoshuang
 * @date 2020-02-19
 **/
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[T.length];

        stack.push(0);
        for (int i = 1; i < T.length; i++) {
            while (!stack.isEmpty()) {
                Integer peek = stack.peek();
                if (T[i] <= T[peek]) {
                    stack.push(i);
                    break;
                } else {
                    result[peek] = i - peek;
                    stack.pop();
                }
            }
            stack.push(i);
        }
        return result;
    }
}
