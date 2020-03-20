package local.algorithm.leetcode;

public class FlipAndInvertImage {

    public int[][] flipAndInvertImage(int[][] A) {
        for (int[] a : A) {
            flip(a);
            invert(a);
        }
        return A;
    }

    private void invert(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                a[i] = 0;
            } else {
                a[i] = 1;
            }
        }
    }

    private void flip(int[] a) {
        for (int start = 0, end = a.length - 1; start < end; start++, end--) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
        }
    }
}
