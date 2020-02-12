package local.algorithm.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author cuixiaoshuang
 * @date 2020-02-12
 **/
public class FindCircleNumUnion {

    public int findCircleNum(int[][] M) {
        int[] parents = new int[M.length];
        Arrays.fill(parents, -1);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1) {
                    union(parents, i, j);
                }
            }
        }
        int count = 0;
        for (int parent : parents) {
            if (parent == -1) {
                count++;
            }
        }
        return count;
    }

    private void union(int[] parents, int i, int j) {
        int parentI = findParent(parents, i);
        int parentJ = findParent(parents, j);
        if (parentI != parentJ) {
            parents[parentI] = parentJ;
        }
    }

    private int findParent(int[] parents, int i) {
        if (parents[i] == -1) {
            return i;
        }
        return findParent(parents, parents[i]);
    }
}
