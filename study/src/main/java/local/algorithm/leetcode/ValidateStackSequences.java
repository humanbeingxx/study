package local.algorithm.leetcode;

import java.util.Stack;

/**
 * @author cuixiaoshuang
 * @date 2020-01-13
 **/
public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int pushIndex = 0, popIndex = 0;
        while (pushIndex < pushed.length) {
            stack.push(pushed[pushIndex]);
            while (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
            }
            pushIndex++;
        }
        return stack.isEmpty();
    }
}
