package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/2 22:02
 */
public class CanThreePartsEqualSum {

    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i : A) {
            sum += i;
        }
        if (sum % 3 != 0) {
            return false;
        }
        int part = sum / 3;
        sum = 0;
        int front = 0, back = A.length - 1;
        for (; front < A.length - 2; front++) {
            sum += A[front];
            if (sum == part) {
                break;
            }
        }
        if (sum != part) {
            return false;
        }
        sum = 0;

        for (; back > front; back--) {
            sum += A[back];
            if (sum == part) {
                return true;
            }
        }
        return false;
    }
}
