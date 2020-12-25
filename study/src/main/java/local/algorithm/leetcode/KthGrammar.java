package local.algorithm.leetcode;

public class KthGrammar {

    public int kthGrammar(int N, int K) {
        return calcRec(N, (int) (Math.pow(2, N - 1) - 1 + K));
    }

    private int calcRec(int level, int k) {
        if (k == 1) {
            return 0;
        }
        boolean isEven = k % 2 == 0;
        int parent = calcRec(level - 1, isEven ? k / 2 : (k - 1) / 2);
        if (parent == 0) {
            if (isEven) {
                return 0;
            } else {
                return 1;
            }
        } else {
            if (isEven) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
