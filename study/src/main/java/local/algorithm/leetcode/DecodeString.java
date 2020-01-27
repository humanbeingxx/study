package local.algorithm.leetcode;

import java.util.Stack;

/**
 * @author cuixiaoshuang
 * @date 2020-01-27
 **/
public class DecodeString {

    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder segment = new StringBuilder();
        StringBuilder count = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                if (segment.length() > 0) {
                    stack.push(segment.toString());
                    segment.setLength(0);
                }
                count.append(c);
            } else if (c != '[' && c != ']') {
                if (count.length() > 0) {
                    stack.push(count.toString());
                    stack.push(c + "");
                }
                segment.append(c);
            } else if (c == '[') {
                if (count.length() > 0) {
                    stack.push(count.toString());
                    stack.push(c + "");
                }
                count.setLength(0);
            } else {
                if (segment.length() > 0) {
                    stack.push(segment.toString());
                    segment.setLength(0);
                }
                decodeSegment(stack);
            }
        }
        if (segment.length() > 0) {
            stack.push(segment.toString());
        }
        segment.setLength(0);
        while (!stack.isEmpty()) {
            segment.insert(0, stack.pop());
        }
        return segment.toString();
    }

    private void decodeSegment(Stack<String> stack) {
        StringBuilder segment = new StringBuilder();
        String piece;
        while (!(piece = stack.pop()).equals("[")) {
            segment.insert(0, piece);
        }
        int count = Integer.parseInt(stack.pop());
        StringBuilder duplicate = new StringBuilder();
        for (int i = 0; i < count; i++) {
            duplicate.append(segment);
        }
        if (!stack.isEmpty() && !stack.peek().equals("[")) {
            duplicate.insert(0, stack.pop());
            stack.push(duplicate.toString());
        } else {
            stack.push(duplicate.toString());
        }

    }
}
