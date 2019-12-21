package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/21 17:37
 */
public class RotatedDigits {

    public int rotatedDigits(int N) {
        if (N < 1 || N > 10000) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (check(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean check(int i) {
        boolean has2569 = false;

        while (i > 0) {
            int left = i % 10;
            if (left == 2 || left == 5 || left == 6 || left == 9) {
                has2569 = true;
            } else {
                if (left != 0 && left != 1 && left != 8) {
                    return false;
                }
            }
            i /= 10;
        }
        return has2569;
    }

    public int rotatedDigits10(int k, int n) {
        if (n == 0) {
            if (k < 2) {
                return 0;
            }
            if (k < 5) {
                return 1;
            }
            if (k < 6) {
                return 2;
            }
            if (k < 9) {
                return 3;
            }
            return 4;
        }
        if (k == 1) {
            return rotatedDigits10(9, n - 1) + (int) Math.pow(7, n - 1) - 1;
        }

        switch (k) {
            case 2:
                return 2 * rotatedDigits10(1, n) + 1;
            case 3:
                return rotatedDigits10(2, n) + (int) Math.pow(7, n) - 1;
            case 4:
                return rotatedDigits10(3, n);
            case 5:
                return rotatedDigits10(4, n) + 1;
            case 6:
                return rotatedDigits10(5, n) + (int) Math.pow(7, n);
            case 7:
                return rotatedDigits10(6, n) + +(int) Math.pow(7, n) - 1;
            case 8:
                return rotatedDigits10(7, n);
            case 9:
                return rotatedDigits10(8, n) + rotatedDigits10(1, n) + 1;
            default:
                return 0;
        }
    }
}
