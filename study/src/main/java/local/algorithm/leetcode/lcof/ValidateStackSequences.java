package local.algorithm.leetcode.lcof;

import java.util.Stack;

public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int pushedIndex = 0, poppedIndex = 0;
        while (pushedIndex < pushed.length) {
            stack.push(pushed[pushedIndex]);
            while (!stack.isEmpty() && popped[poppedIndex] == stack.peek()) {
                stack.pop();
                poppedIndex++;
            }
            pushedIndex++;
        }
        return stack.isEmpty();
    }
}
