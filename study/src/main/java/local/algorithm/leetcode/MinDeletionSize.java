package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/21 22:01
 */
public class MinDeletionSize {

    public int minDeletionSize(String[] A) {
        int count = 0;
        if (A.length <= 1) {
            return 0;
        }

        for (int i = 0; i < A[0].length(); i++) {
            for (int j = 0; j < A.length - 1; j++) {
                if (A[j].charAt(i) > A[j + 1].charAt(i)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
