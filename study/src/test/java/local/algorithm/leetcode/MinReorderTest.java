package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MinReorderTest {

    @Test
    public void testMinReorder1() {
        int result = new MinReorder().minReorder(6, new int[][]{
                {0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}
        });
        assertEquals(result, 3);
    }

    @Test
    public void testMinReorder2() {
        int result = new MinReorder().minReorder(5, new int[][]{
                {1,0},{1,2},{3,2},{3,4}
        });
        assertEquals(result, 2);
    }

    @Test
    public void testMinReorder3() {
        int result = new MinReorder().minReorder(4, new int[][]{
                {0,1},{2,0},{3,2}
        });
        assertEquals(result, 1);
    }
}