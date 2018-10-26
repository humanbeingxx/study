package local.before.d1026;

/**
 * @author xiaoshuang.cui
 * @date 2018/10/26 下午9:44
 **/
public class NeighbourMatrix {

    public static int[][] findNeighbour(int[][] matrix) {
        if (matrix == null || matrix.length <= 1 || matrix[0].length <= 1) {
            return null;
        }

        int[][] result = new int[matrix.length][matrix[0].length];

        for (int i = 1; i < matrix.length - 1; i++) {
            for (int j = 1; j < matrix[0].length - 1; j++) {
                if (checkNeighbour(matrix, i, j)) {
                    result[i][j] = 1;
                }
            }
        }

        return result;
    }

    private static boolean checkNeighbour(int[][] matrix, int i, int j) {
        return matrix[i][j + 1] == 1 && matrix[i][j - 1] == 1 && matrix[i - 1][j] == 1 && matrix[i + 1][j] == 1;
    }
}
