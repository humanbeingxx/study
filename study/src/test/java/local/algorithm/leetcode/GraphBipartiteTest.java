package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class GraphBipartiteTest {

    @Test
    public void testIsBipartite1() {
        boolean result = new GraphBipartite().isBipartite(new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}});
        assertTrue(result);
    }

    @Test
    public void testIsBipartite2() {
        boolean result = new GraphBipartite().isBipartite(new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}});
        assertFalse(result);
    }
}