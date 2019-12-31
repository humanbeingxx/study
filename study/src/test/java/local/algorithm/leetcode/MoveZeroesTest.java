package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2019-12-31
 **/
public class MoveZeroesTest {

    @Test
    public void testMoveZeroes1() {
        int[] data = {0, 1, 0, 3, 12};
        new MoveZeroes().moveZeroes(data);
        assertEquals(data, new int[]{1, 3, 12, 0, 0});
    }

    @Test
    public void testMoveZeroes2() {
        int[] data = {0};
        new MoveZeroes().moveZeroes(data);
        assertEquals(data, new int[]{0});
    }

    @Test
    public void testMoveZeroes3() {
        int[] data = {1};
        new MoveZeroes().moveZeroes(data);
        assertEquals(data, new int[]{1});
    }

    @Test
    public void testMoveZeroes4() {
        int[] data = {0, 0, 0};
        new MoveZeroes().moveZeroes(data);
        assertEquals(data, new int[]{0, 0, 0});
    }

    @Test
    public void testMoveZeroes5() {
        int[] data = {1, 1, 1};
        new MoveZeroes().moveZeroes(data);
        assertEquals(data, new int[]{1, 1, 1});
    }
}