package local.algorithm.leetcode;

import java.util.Stack;

public class SmallestSubsequenceOfDistinctCharacters {

    public String smallestSubsequence(String s) {
        Stack<Character> stack = new Stack<>();
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        boolean[] contains = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            counts[c - 'a']--;
            if (!contains[c - 'a']) {
                while (!stack.isEmpty()) {
                    Character peek = stack.peek();
                    if (counts[peek - 'a'] > 0 && peek > c) {
                        stack.pop();
                        contains[peek - 'a'] = false;
                    } else {
                        break;
                    }
                }
                stack.push(c);
                contains[c - 'a'] = true;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(stack.size());
        for (Character c : stack) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
