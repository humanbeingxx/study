package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @author cuixiaoshuang
 * @date 2020-02-25
 **/
public class GenerateSpiralMatrixTest {

    @Test
    public void testGenerateMatrix1() {
        int[][] result = new GenerateSpiralMatrix().generateMatrix(1);
        for (int i = 0; i < 1; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }

    @Test
    public void testGenerateMatrix3() {
        int[][] result = new GenerateSpiralMatrix().generateMatrix(3);
        for (int i = 0; i < 3; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }

    @Test
    public void testGenerateMatrix4() {
        int[][] result = new GenerateSpiralMatrix().generateMatrix(4);
        for (int i = 0; i < 4; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }
}