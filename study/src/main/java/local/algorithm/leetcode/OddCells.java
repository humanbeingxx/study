package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-03
 **/
public class OddCells {

    public int oddCells(int n, int m, int[][] indices) {
        boolean[] ns = new boolean[n];
        boolean[] ms = new boolean[m];

        for (int i = 0; i < indices.length; i++) {
            ns[indices[i][0]] = !ns[indices[i][0]];
            ms[indices[i][1]] = !ms[indices[i][1]];
        }

        int nc = 0, mc = 0;
        for (boolean b : ns) {
            if (b) {
                nc++;
            }
        }
        for (boolean b : ms) {
            if (b) {
                mc++;
            }
        }

        return nc * m + mc * n - nc * mc * 2;
    }
}
