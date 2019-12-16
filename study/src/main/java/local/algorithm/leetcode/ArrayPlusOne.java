package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-16
 **/
public class ArrayPlusOne {

    public int[] plusOne(int[] digits) {
        if (digits.length < 1) {
            return new int[0];
        }

        int[] added;

        boolean all9 = true;
        for (int digit : digits) {
            if (digit != 9) {
                all9 = false;
                break;
            }
        }

        if (all9) {
            added = new int[digits.length + 1];
            added[0] = 1;
            return added;
        } else {
            added = new int[digits.length];
        }

        int keep = (digits[digits.length -1] + 1) / 10;
        added[digits.length -1] = (digits[digits.length -1] + 1) % 10;
        for (int i = digits.length - 2; i >= 0; i--) {
            added[i] = (digits[i] + keep) % 10;
            keep = (digits[i] + keep) / 10;
        }

        return added;
    }
}
