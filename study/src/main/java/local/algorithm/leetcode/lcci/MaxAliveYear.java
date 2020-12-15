package local.algorithm.leetcode.lcci;

public class MaxAliveYear {

    public int maxAliveYear(int[] birth, int[] death) {
        int[] lives = new int[1000];
        for (int b : birth) {
            lives[b - 1900]++;
        }
        for (int d : death) {
            lives[d - 1900 + 1]--;
        }
        int[] presum = new int[1000];
        presum[0] = lives[0];
        int maxYear = 0, maxLive = 0;
        for (int i = 1; i < lives.length; i++) {
            presum[i] = lives[i] + presum[i-1];
            if (presum[i] > maxLive) {
                maxLive = presum[i];
                maxYear = i;
            }
        }
        return maxYear + 1900;
    }
}
