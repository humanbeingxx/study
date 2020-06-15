package local.algorithm.leetcode.lcof;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/12 15:52
 */
public class TranslateNum {

    public int translateNum(int num) {
        if (num < 10) {
            return 1;
        }
        char[] chars = Integer.toString(num).toCharArray();
        int len = chars.length;

        int count = 1, countPre = 1;
        for (int i = 2; i <= len; i++) {
            int index = len - i;
            if (inBoundary(chars, index)) {
                count += countPre;
                countPre = count - countPre;
            } else {
                countPre = count;
            }
        }
        return count;
    }

    private boolean inBoundary(char[] chars, int index) {
        char first = chars[index];
        char second = chars[index + 1];
        return first == '1' || (first == '2' && second <= '5');
    }
}
