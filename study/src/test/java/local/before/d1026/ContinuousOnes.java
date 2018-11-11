package local.before.d1026;

import org.apache.commons.lang3.tuple.Pair;
import org.testng.collections.Lists;

import java.util.List;

/**
 * @author xiaoshuang.cui
 * @date 2018/10/26 下午10:10
 **/
public class ContinuousOnes {

    public static List<List<Pair<Integer, Integer>>> find(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }

        List<List<Pair<Integer, Integer>>> result = Lists.newArrayList();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                List<Pair<Integer, Integer>> oneTurn = Lists.newArrayList();
                if (matrix[i][j] == 1) {
                    findRec(matrix, i, j, oneTurn);
                }
                if (oneTurn.size() > 0) {
                    result.add(oneTurn);
                }
            }
        }

        return result;
    }

    private static void findRec(int[][] matrix, int i, int j, List<Pair<Integer, Integer>> result) {
        if (i < 0 || i == matrix.length || j < 0 || j == matrix[0].length) {
            return;
        }
        matrix[i][j] = 0;
        result.add(Pair.of(i, j));
        if (i > 0 && matrix[i - 1][j] == 1) {
            findRec(matrix, i - 1, j, result);
        }
        if (j > 0 && matrix[i][j - 1] == 1) {
            findRec(matrix, i, j - 1, result);
        }
        if (i < matrix.length - 1 && matrix[i + 1][j] == 1) {
            findRec(matrix, i + 1, j, result);
        }
        if (j < matrix[0].length - 1 && matrix[i][j + 1] == 1) {
            findRec(matrix, i, j + 1, result);
        }
    }
}
