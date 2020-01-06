package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-06
 **/
public class NumSmallerByFrequency {

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] result = new int[queries.length];
        int[] qc = new int[queries.length];
        int[] wc = new int[words.length];
        for (int i = 0; i < queries.length; i++) {
            qc[i] = count(queries[i]);
        }
        for (int i = 0; i < words.length; i++) {
            wc[i] = count(words[i]);
        }
        for (int i = 0; i < qc.length; i++) {
            for (int j = 0; j < wc.length; j++) {
                if (qc[i] < wc[j]) {
                    result[i]++;
                }
            }
        }

        return result;
    }

    int count(String s) {
        char c = 'z';
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            if (sc < c) {
                count = 1;
                c = sc;
            } else if (sc == c) {
                count++;
            }
        }
        return count;
    }
}
