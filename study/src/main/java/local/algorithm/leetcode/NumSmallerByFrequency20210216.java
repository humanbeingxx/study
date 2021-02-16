package local.algorithm.leetcode;

import java.util.Arrays;

public class NumSmallerByFrequency20210216 {

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] counts = new int[words.length];
        int[] result = new int[queries.length];
        for (int i = 0; i < words.length; i++) {
            counts[i] = count(words[i]);
        }
        Arrays.sort(counts);
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            int queryCount = count(query);
            result[i] = words.length - firstBigger(counts, queryCount);
        }
        return result;
    }

    private int count(String word) {
        char minC = 'z';
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c < minC) {
                minC = c;
                count = 1;
            } else if (c == minC){
                count++;
            }
        }
        return count;
    }

    int firstBigger(int[] data, int target) {
        int low = 0, high = data.length - 1, mid;
        while (low < high) {
            mid = (low + high) / 2;
            if (data[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (data[low] <= target) {
            return low + 1;
        } else {
            return low;
        }
    }
}
