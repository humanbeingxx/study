package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FindLongestChainTest {
    @Test
    public void testFindLongestChain2() {
        int result = new FindLongestChain().findLongestChain(new int[][]{
                {9, 10}, {9, 10}, {4, 5}, {-9, -3}, {-9, 1}, {0, 3}, {6, 10}, {-5, -4}, {-7, -6}
        });
        assertEquals(result, 5);
    }
}