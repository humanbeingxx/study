package local.algorithm.leetcode;

public class UglyNumberII {

    public int nthUglyNumber(int n) {
        int[] numbers = new int[n];
        int index2 = 0, index3 = 0, index5 = 0;
        numbers[0] = 1;
        for (int i = 1; i < n; i++) {
            numbers[i] = Math.min(numbers[index2] * 2, Math.min(numbers[index3] * 3, numbers[index5] * 5));
            if (numbers[i] == numbers[index2] * 2) {
                index2++;
            }

            if (numbers[i] == numbers[index3] * 3) {
                index3++;
            }

            if (numbers[i] == numbers[index5] * 5) {
                index5++;
            }
        }
        return numbers[n - 1];
    }
}
