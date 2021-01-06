package local.algorithm.leetcode;

import java.util.Stack;

public class EvalRPN {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (isOp(token)) {
                int val2 = stack.pop();
                int val1 = stack.pop();
                int calc = calc(val1, val2, token);
                stack.push(calc);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private boolean isOp(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private int calc(int val1, int val2, String op) {
        switch (op) {
            case "+":
                return val1 + val2;
            case "-":
                return val1 - val2;
            case "*":
                return val1 * val2;
            case "/":
                return val1 / val2;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
