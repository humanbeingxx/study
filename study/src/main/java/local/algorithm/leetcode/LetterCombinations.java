package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/17 1:08
 */
public class LetterCombinations {

    static Map<Character, char[]> mapping = new HashMap<>();

    static {
        mapping.put('1', new char[0]);
        mapping.put('2', new char[]{'a', 'b', 'c'});
        mapping.put('3', new char[]{'d', 'e', 'f'});
        mapping.put('4', new char[]{'g', 'h', 'i'});
        mapping.put('5', new char[]{'j', 'k', 'l'});
        mapping.put('6', new char[]{'m', 'n', 'o'});
        mapping.put('7', new char[]{'p', 'q', 'r', 's'});
        mapping.put('8', new char[]{'t', 'u', 'v'});
        mapping.put('9', new char[]{'w', 'x', 'y', 'z'});
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        combine(0, digits, new StringBuilder(), result);
        return result;
    }

    private void combine(int pos, String digits, StringBuilder sb, List<String> result) {
        if (pos == digits.length()) {
            result.add(sb.toString());
            return;
        }
        if (digits.charAt(pos) == '1') {
            combine(pos + 1, digits, sb, result);
            return;
        }
        char[] chars = mapping.get(digits.charAt(pos));
        for (char aChar : chars) {
            sb.append(aChar);
            combine(pos + 1, digits, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
