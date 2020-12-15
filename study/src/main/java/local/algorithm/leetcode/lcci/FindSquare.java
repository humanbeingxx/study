package local.algorithm.leetcode.lcci;

public class FindSquare {

    public int[] findSquare(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int[][][] boundaries = new int[2][matrix.length][matrix[0].length];
        int[] maxSize = new int[]{-1, -1, 0};
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0 && j == 0) {
                        boundaries[0][i][j] = 1;
                        boundaries[1][i][j] = 1;
                    } else if (i == 0) {
                        boundaries[0][i][j] = 1;
                        boundaries[1][i][j] = boundaries[1][i][j - 1] + 1;
                    } else if (j == 0) {
                        boundaries[0][i][j] = boundaries[0][i - 1][j] + 1;
                        boundaries[1][i][j] = 1;
                    } else {
                        boundaries[0][i][j] = boundaries[0][i - 1][j] + 1;
                        boundaries[1][i][j] = boundaries[1][i][j - 1] + 1;
                    }
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int bound = Math.min(boundaries[0][i][j], boundaries[1][i][j]);
                if (bound == 1) {
                    if (maxSize[2] == 0) {
                        maxSize[0] = i - bound + 1;
                        maxSize[1] = j - bound + 1;
                        maxSize[2] = 1;
                    }
                } else if (bound > 1) {
                    for (int k = bound; k > 1; k--) {
                        if (boundaries[0][i][j - k + 1] >= k && boundaries[1][i - k + 1][j] >= k) {
                            if (k > maxSize[2]) {
                                maxSize[0] = i - k + 1;
                                maxSize[1] = j - k + 1;
                                maxSize[2] = k;
                            }
                            break;
                        }
                    }
                }
            }
        }
        return maxSize[0] < 0 ? new int[0] : maxSize;
    }
}
