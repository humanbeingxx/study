package local.algorithm.leetcode;

public class SubarraysDivByK {

    public int subarraysDivByK(int[] A, int K) {
        int[] remains = new int[K];
        remains[0] = 1;
        int sum = 0, count = 0;
        for (int i = 1; i <= A.length; i++) {
            sum += A[i - 1];
            int remain = (sum % K + K) % K;
            count += remains[remain];
            remains[remain]++;
        }
        return count;
    }
}
