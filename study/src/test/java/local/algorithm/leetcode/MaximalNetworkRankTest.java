package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MaximalNetworkRankTest {

    @Test
    public void testMaximalNetworkRank1() {
        int result = new MaximalNetworkRank().maximalNetworkRank(15, new int[][]{
                {8,12},{5,11},{5,12},{9,4},{0,9},{1,8},{10,2},{13,14},{3,4},{11,3},{11,8},{5,10}
        });
        assertEquals(result, 6);
    }
    @Test
    public void testMaximalNetworkRank2() {
        int result = new MaximalNetworkRank().maximalNetworkRank(27, new int[][]{
                {4,21},{15,20},{21,12},{0,25},{23,15},{8,0},{1,15},{3,14},{10,6},{13,19},{13,14},{10,9},{9,1},{4,18},{20,21},{8,20},{7,5},{5,20},{26,16},{13,15},{5,9},{21,1},{1,22},{5,15},{2,25},{0,24},{6,4},{5,17},{6,20},{4,16},{23,7},{2,3},{9,17},{4,13},{12,1},{1,25},{7,18},{5,18},{11,1},{6,15},{19,17},{15,24},{4,9},{0,22},{5,23},{8,2},{7,1},{19,16},{13,0},{6,3},{17,23},{12,24},{17,7},{18,14},{5,16},{7,13},{3,23},{22,20},{25,26},{5,24}
        });
        assertEquals(result, 17);
    }
}