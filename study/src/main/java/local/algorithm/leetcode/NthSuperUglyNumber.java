package local.algorithm.leetcode;

public class NthSuperUglyNumber {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] indices = new int[primes.length];
        int[] numbers = new int[n];
        numbers[0] = 1;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                min = Math.min(min, primes[j] * numbers[indices[j]]);
            }
            numbers[i] = min;
            for (int j = 0; j < indices.length; j++) {
                if (min == primes[j] * numbers[indices[j]]) {
                    indices[j]++;
                }
            }
        }
        return numbers[n - 1];
    }
}
