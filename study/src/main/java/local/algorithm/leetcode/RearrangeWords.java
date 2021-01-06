package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class RearrangeWords {

    public String arrangeWords(String text) {
        TreeMap<Integer, List<String>> buckets = new TreeMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((char) (text.charAt(0) - 'A' + 'a'));
        for (int i = 1; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == ' ') {
                buckets.putIfAbsent(stringBuilder.length(), new ArrayList<>());
                buckets.get(stringBuilder.length()).add(stringBuilder.toString());
                stringBuilder.setLength(0);
            } else {
                if (c >= 'A' && c <= 'Z') {
                    c = (char) (c - 'A' + 'a');
                }
                stringBuilder.append(c);
            }
        }
        if (stringBuilder.length() > 0) {
            buckets.putIfAbsent(stringBuilder.length(), new ArrayList<>());
            buckets.get(stringBuilder.length()).add(stringBuilder.toString());
            stringBuilder.setLength(0);
        }
        for (List<String> words : buckets.values()) {
            for (String word : words) {
                stringBuilder.append(word).append(' ');
            }
        }
        stringBuilder.setLength(stringBuilder.length() - 1);
        stringBuilder.setCharAt(0, (char) (stringBuilder.charAt(0) - 'a' + 'A'));
        return stringBuilder.toString();
    }
}
