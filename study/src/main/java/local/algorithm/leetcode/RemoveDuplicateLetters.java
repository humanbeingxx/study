package local.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Character> existInStack = new HashSet<>();
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
                existInStack.add(c);
            } else if (!existInStack.contains(c)) {
                Character peek;
                while (!stack.isEmpty() && (peek = stack.peek()) >= c) {
                    if (peek == c || lastIndex[peek - 'a'] > i) {
                        existInStack.remove(peek);
                        stack.pop();
                    } else {
                        break;
                    }
                }
                stack.push(c);
                existInStack.add(c);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Character c : stack) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
