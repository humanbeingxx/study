package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-02-16
 **/
public class KClosestTest {

    @Test
    public void testKClosest1() {
        int[][] result = new KClosest().kClosest(new int[][]{{1, 3}, {-2, 2}}, 1);
        assertEquals(result.length, 1);
        assertEquals(result[0], new int[]{-2, 2});
    }

    @Test
    public void testKClosest2() {
        int[][] result = new KClosest().kClosest(new int[][]{{3,3},{5,-1},{-2,4}}, 2);
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }
}