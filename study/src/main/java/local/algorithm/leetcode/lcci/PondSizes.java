package local.algorithm.leetcode.lcci;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PondSizes {

    public int[] pondSizes(int[][] land) {
        boolean[][] checked = new boolean[land.length][land[0].length];
        List<Integer> pondSizes = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                int size = checkRec(i, j, land, checked, pondSizes);
                if (size > 0) {
                    pondSizes.add(size);
                }
            }
        }
        Collections.sort(pondSizes);
        int[] result = new int[pondSizes.size()];
        for (int i = 0; i < pondSizes.size(); i++) {
            result[i] = pondSizes.get(i);
        }
        return result;
    }

    private int checkRec(int i, int j, int[][] land, boolean[][] checked, List<Integer> pondSizes) {
        if (i < 0 || j < 0 || i == land.length || j == land[0].length || land[i][j] != 0 || checked[i][j]) {
            return 0;
        }
        checked[i][j] = true;
        return 1 + checkRec(i - 1, j - 1, land, checked, pondSizes)
                + checkRec(i - 1, j, land, checked, pondSizes)
                + checkRec(i - 1, j + 1, land, checked, pondSizes)
                + checkRec(i, j - 1, land, checked, pondSizes)
                + checkRec(i, j + 1, land, checked, pondSizes)
                + checkRec(i + 1, j - 1, land, checked, pondSizes)
                + checkRec(i + 1, j, land, checked, pondSizes)
                + checkRec(i + 1, j + 1, land, checked, pondSizes);
    }
}
