package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-02-05
 **/
public class MaximumSwap {

    public int maximumSwap(int num) {
        char[] origin = Integer.toString(num).toCharArray();
        for (int i = 0; i < origin.length; i++) {
            for (int j = i + 1; j < origin.length; j++) {
                int maxIndex = lastMax(origin, j);
                if (origin[maxIndex] > origin[i]) {
                    return exchange(origin, i, maxIndex);
                }
            }
        }
        return num;
    }

    private int lastMax(char[] chars, int firstIndex) {
        int max = 0, index = 0;
        for (int i = chars.length - 1; i >= firstIndex; i--) {
            if (chars[i] > max) {
                max = chars[i];
                index = i;
            }
        }
        return index;
    }

    private int exchange(char[] chars, int from, int to) {
        char temp = chars[from];
        chars[from] = chars[to];
        chars[to] = temp;
        return Integer.parseInt(new String(chars));
    }
}
