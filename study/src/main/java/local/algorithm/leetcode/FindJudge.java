package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-23
 **/
public class FindJudge {

    public int findJudge(int N, int[][] trust) {
        int judge = 0, judgeCount = 0;
        int[] trustMe = new int[N];
        int[] trustElse = new int[N];
        for (int[] ints : trust) {
            int I = ints[0];
            int other = ints[1];
            trustElse[I - 1]++;
            trustMe[other - 1]++;
        }
        for (int i = 0; i < trustMe.length; i++) {
            if (trustElse[i] == 0 && trustMe[i] == N - 1) {
                judgeCount++;
                judge = i + 1;
            }
        }
        return judgeCount == 1 ? judge : -1;
    }
}
