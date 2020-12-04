package local.algorithm.leetcode.lcci;

public class FindClosedNumbers {

    public int[] findClosedNumbers(int num) {
        int[] result = new int[]{-1, -1};
        int base = 1, count1 = 0;
        while (base << 1 > 0) {
            if ((num & (base | base << 1)) == base) {
                //01
                result[0] = (num & ~((base << 1) - 1)) | base << 1;
                int move = 1;
                for (int i = 0; i < count1; i++) {
                    result[0] |= move;
                    move <<=1;
                }
                break;
            } else if ((num & base) == base) {
                count1++;
            }
            base <<= 1;
        }
        base = 1;
        count1 = 0;
        while (base << 1 > 0) {
            if ((num & (base | base << 1)) == base << 1) {
                //10
                result[1] = num & ~((base << 2) - 1);
                for (int i = 0; i <= count1; i++) {
                    result[1] |= base;
                    base >>= 1;
                }
                break;
            } else if ((num & base) == base) {
                count1++;
            }
            base <<= 1;
        }
        return result;
    }
}
