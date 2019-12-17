package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-17
 **/
public class ConcatString {

    public int countCharacters(String[] words, String chars) {
        if (words.length == 0 || chars.length() == 0) {
            return 0;
        }
        int[] alphaCount = new int[26];
        int[] wordCount = new int[26];
        for (char c : chars.toCharArray()) {
            alphaCount[c - 'a'] += 1;
        }
        int sum = 0;
        boolean satisfied = true;
        for (String word : words) {
            for (char c : word.toCharArray()) {
                wordCount[c - 'a'] += 1;
            }

            for (char c = 'a'; c <= 'z'; c++) {
                if (wordCount[c - 'a'] > alphaCount[c - 'a']) {
                    satisfied = false;
                }
                wordCount[c - 'a'] = 0;
            }
            if (satisfied) {
                sum += word.length();
            }
            satisfied = true;
        }
        return sum;
    }
}
