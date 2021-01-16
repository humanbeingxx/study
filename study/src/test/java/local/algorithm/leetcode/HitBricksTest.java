package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Random;

public class HitBricksTest {

    @Test
    public void testHitBricks1() {
        int[] result = new HitBricks().hitBricks(new int[][]{
                {1, 0, 0, 0}, {1, 1, 1, 0}
        }, new int[][]{
                {1, 1}, {1, 0}
        });
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testHitBricks2() {
        int[] result = new HitBricks().hitBricks(new int[][]{
                {1, 0, 0, 0}, {1, 1, 1, 0}
        }, new int[][]{
                {1, 0}
        });
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testHitBricks3() {
        int[] result = new HitBricks().hitBricks(new int[][]{
                {1, 0, 0, 0}, {1, 1, 0, 0}
        }, new int[][]{
                {1, 1}, {1, 0}
        });
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testHitBricks4() {
        int[] result = new HitBricks().hitBricks(new int[][]{
                {1, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {1, 0, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {0, 1, 0, 0, 0}

        }, new int[][]{
                {1, 1}, {1, 0}
        });
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testHitBricks5() {
        int[] result = new HitBricks().hitBricks(new int[][]{
                {1, 0, 1},
                {1, 1, 1}

        }, new int[][]{
                {0,0}, {0, 2}, {1,1}
        });
        System.out.println(Arrays.toString(result));
    }


    @Test
    public void testRandom() {
        Random random = new Random();
        int[][] data = new int[5][5];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                data[i][j] = random.nextInt(2);
            }
            System.out.println(Arrays.toString(data[i]));
        }

    }
}