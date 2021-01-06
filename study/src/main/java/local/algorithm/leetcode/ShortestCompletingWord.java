package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-24
 **/
public class ShortestCompletingWord {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] licensePlateCount = new int[26];
        licensePlate = licensePlate.toLowerCase();
        count(licensePlate, licensePlateCount);

        int minLen = Integer.MAX_VALUE;
        String result = "";
        int[] wordCount = new int[26];
        for (String word : words) {
            word = word.toLowerCase();
            count(word, wordCount);

            if (!checkContainAll(wordCount, licensePlateCount)) {
                clear(wordCount);
                continue;
            }

            if (word.length() < minLen) {
                minLen = word.length();
                result = word;
            }
            clear(wordCount);
        }
        return result;
    }

    private void clear(int[] counter) {
        for (int i = 0; i < counter.length; i++) {
            counter[i] = 0;
        }
    }

    private boolean checkContainAll(int[] wordCount, int[] licensePlateCount) {
        for (int i = 0; i < 26; i++) {
            if (licensePlateCount[i] == 0) {
                continue;
            }
            if (licensePlateCount[i] > wordCount[i]) {
                return false;
            }
        }
        return true;
    }

    void count(String word, int[] counter) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= 'a' && c <= 'z') {
                counter[c - 'a']++;
            }
        }
    }
}
