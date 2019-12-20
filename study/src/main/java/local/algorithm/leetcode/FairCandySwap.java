package local.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author cuixiaoshuang
 * @date 2019-12-19
 **/
public class FairCandySwap {

    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0, sumB = 0;
        for (int i : A) {
            sumA += i;
        }
        for (int i : B) {
            sumB += i;
        }

        int sub = sumA - sumB;

        for (int a : A) {
            for (int b : B) {
                if ((a - b) * 2 == sub) {
                    return new int[]{a, b};
                }
            }
        }

        return null;
    }

    public int[] fairCandySwap2(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int sumA = 0, sumB = 0;
        for (int i : A) {
            sumA += i;
        }
        for (int i : B) {
            sumB += i;
        }

        int sub = sumA - sumB;

        for (int a : A) {
            int search = Arrays.binarySearch(B, a - sub / 2);
            if (search >= 0) {
                return new int[]{a, B[search]};
            }
        }

        return null;
    }
}
