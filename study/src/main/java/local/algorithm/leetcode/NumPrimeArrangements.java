package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-31
 **/
public class NumPrimeArrangements {

    public int numPrimeArrangements(int n) {
        int m = 1000000007;
        int numberOfPrime = countPrime(n);
        long result = 1;
        for (int i = 2; i <= numberOfPrime; i++) {
            result = (result * i) % m;
        }
        for (int i = 2; i <= n - numberOfPrime; i++) {
            result = (result * i) % m;
        }
        return (int) result;
    }

    int countPrime(int n) {
        int[] ints = new int[n + 1];
        for (int i = 2; i < n + 1; i++) {
            ints[i] = i;
        }
        for (int i = 2; i < n + 1; i++) {
            if (ints[i] != 0) {
                for (int j = i; j * i < n + 1; j++) {
                    ints[j*i] = 0;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n + 1; i++) {
            if (ints[i] != 0) {
                count++;
            }
        }
        return count;
    }
}
