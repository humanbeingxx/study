package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/15 15:45
 */
public class MaxNumberOfBalloons {

    public int maxNumberOfBalloons(String text) {
        //b, a, l, o, n
        int[] counts = new int[26];
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            counts[c - 'a']++;
        }
        return min(counts['b' - 'a'], counts['a' - 'a'], counts['l' - 'a'] / 2, counts['o' - 'a'] / 2, counts['n' - 'a']);
    }

    private int min(int... counts) {
        int min = Integer.MAX_VALUE;
        for (int count : counts) {
            if (count < min) {
                min = count;
            }
        }
        return min;
    }
}
