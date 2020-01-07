package local.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cuixiaoshuang
 * @date 2020-01-07
 **/
public class UniqueMorseRepresentations {

    String[] alphabet = new String[]{
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---",
            ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
    };

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> uniques = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                sb.append(alphabet[c - 'a']);
            }
            uniques.add(sb.toString());
        }
        return uniques.size();
    }
}
