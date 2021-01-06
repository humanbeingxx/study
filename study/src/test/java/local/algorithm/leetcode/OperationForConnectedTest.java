package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class OperationForConnectedTest {

    @Test
    public void testMakeConnected1() {
        int result = new OperationForConnected().makeConnected(4, new int[][]{{0, 1}, {0, 2}, {1, 2}});
        assertEquals(result, 1);
    }

    @Test
    public void testMakeConnected2() {
        int result = new OperationForConnected().makeConnected(4, new int[][]{});
        assertEquals(result, -1);
    }

    @Test
    public void testMakeConnected3() {
        int result = new OperationForConnected().makeConnected(6, new int[][]{
                {0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}
        });
        assertEquals(result, 2);
    }

    @Test
    public void testMakeConnected1_2() {
        int result = new OperationForConnected().makeConnected2(4, new int[][]{{0, 1}, {0, 2}, {1, 2}});
        assertEquals(result, 1);
    }

    @Test
    public void testMakeConnected2_2() {
        int result = new OperationForConnected().makeConnected2(4, new int[][]{});
        assertEquals(result, -1);
    }

    @Test
    public void testMakeConnected3_2() {
        int result = new OperationForConnected().makeConnected2(6, new int[][]{
                {0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}
        });
        assertEquals(result, 2);
    }

    @Test
    public void testMakeConnected4_2() {
        int result = new OperationForConnected().makeConnected2(11, new int[][]{
                {1, 4}, {0, 3}, {1, 3}, {3, 7}, {2, 7}, {0, 1}, {2, 4}, {3, 6}, {5, 6}, {6, 7}, {4, 7}, {0, 7}, {5, 7}
        });
        assertEquals(result, 3);
    }

    @Test
    public void testMakeConnected5_2() {
        int result = new OperationForConnected().makeConnected2(10, new int[][]{
                {6, 8}, {0, 4}, {1, 2}, {5, 8}, {0, 9}, {1, 8}, {1, 4}, {4, 9}, {4, 6}, {3, 7}, {2, 4}, {3, 5}, {6, 7}, {4, 5}
        });
        assertEquals(result, 0);
    }
}