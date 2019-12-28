package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-27
 **/
public class NextGreatestLetter {

    public char nextGreatestLetter(char[] letters, char target) {

        int low = 0, high = letters.length - 1, pos = (low + high) / 2;
        while (low <= high) {
            if (letters[pos] <= target) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
            pos = (low + high) / 2;
        }
        if (low == letters.length) {
            return letters[0];
        } else {
            return letters[low];
        }
    }
}
