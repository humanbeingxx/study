package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LongestIncreasingPathTest {

    @Test
    public void testLongestIncreasingPath1() {
        int result = new LongestIncreasingPath().longestIncreasingPath(new int[][]{
                {7, 8, 9}, {9, 7, 6}, {7, 2, 3}
        });
        Assert.assertEquals(result, 6);
    }
}