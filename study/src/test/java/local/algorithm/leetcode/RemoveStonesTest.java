package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RemoveStonesTest {

    @Test
    public void testRemoveStones1() {
        int result = new RemoveStones().removeStones(new int[][]{
                {0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}
        });
        assertEquals(result, 5);
    }

    @Test
    public void testRemoveStones2() {
        int result = new RemoveStones().removeStones(new int[][]{
                {0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}
        });
        assertEquals(result, 3);
    }

    @Test
    public void testRemoveStones3() {
        int result = new RemoveStones().removeStones(new int[][]{
                {1, 1}, {0, 1}
        });
        assertEquals(result, 1);
    }
}