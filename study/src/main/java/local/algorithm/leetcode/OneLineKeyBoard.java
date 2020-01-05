package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/1 14:53
 */
public class OneLineKeyBoard {

    Set<Character> line1 = new HashSet<>();
    Set<Character> line2 = new HashSet<>();
    Set<Character> line3 = new HashSet<>();

    {
        line1.add('q');
        line1.add('w');
        line1.add('e');
        line1.add('r');
        line1.add('t');
        line1.add('y');
        line1.add('u');
        line1.add('i');
        line1.add('o');
        line1.add('p');
        line2.add('a');
        line2.add('s');
        line2.add('d');
        line2.add('f');
        line2.add('g');
        line2.add('h');
        line2.add('j');
        line2.add('k');
        line2.add('l');
        line3.add('z');
        line3.add('x');
        line3.add('c');
        line3.add('v');
        line3.add('b');
        line3.add('n');
        line3.add('m');
    }

    public String[] findWords(String[] words) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            Set<Character> set = findSet(word.charAt(0));
            boolean oneLine = true;
            for (int i = 0; i < word.length(); i++) {
                if (!set.contains(low(word.charAt(i)))) {
                    oneLine =false;
                    break;
                }
            }
            if (oneLine) {
                result.add(word);
            }
        }
        return result.toArray(new String[0]);
    }

    private char low(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char)(c + 'a' - 'A');
        } else {
            return c;
        }
    }

    private Set<Character> findSet(char c) {
        c = low(c);
        if (line1.contains(c)) {
            return line1;
        } else if (line2.contains(c)) {
            return line2;
        } else {
            return line3;
        }
    }
}
