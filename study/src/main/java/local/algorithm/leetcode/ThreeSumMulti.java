package local.algorithm.leetcode;

import java.util.Arrays;

public class ThreeSumMulti {

    public int threeSumMulti(int[] A, int target) {
        int[][] numCounts = new int[A.length][201];
        for (int i = 2; i < A.length; i++) {
            numCounts[2][A[i]]++;
        }
        for (int i = 3; i < A.length; i++) {
            System.arraycopy(numCounts[i - 1], 0, numCounts[i], 0, 101);
            numCounts[i][A[i - 1]] = numCounts[i - 1][A[i - 1]] - 1;
        }
        long count = 0;
        for (int i = 0; i < A.length - 2; i++) {
            for (int j = i + 1; j < A.length - 1; j++) {
                int searchFor = target - A[i] - A[j];
                if (searchFor < 0) {
                    continue;
                }
                int[] counts = numCounts[j + 1];
                count += counts[searchFor];
            }
        }
        return (int) (count % 1000000007);
    }

    public int threeSumMulti2(int[] A, int target) {
        Arrays.sort(A);
        long count = 0;
        for (int i = 1; i < A.length - 1; i++) {
            int left = 0, right = A.length - 1;
            while (left < i && right > i) {
                int sum = A[left] + A[right] + A[i];
                if (sum == target) {
                    left++;
                    right--;
                    int leftSame = 1, rightSame = 1;
                    while (left < i && A[left] == A[left - 1]) {
                        leftSame++;
                        left++;
                    }
                    while (right > i && A[right] == A[right + 1]) {
                        right--;
                        rightSame++;
                    }
                    count += leftSame * rightSame;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return (int) (count % 1000000007);
    }
}
