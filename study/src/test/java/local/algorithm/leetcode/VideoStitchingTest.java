package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class VideoStitchingTest {

    @Test
    public void testVideoStitching1() {
        int result = new VideoStitching().videoStitching(new int[][]{{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}}, 10);
        assertEquals(result, 3);
    }

    @Test
    public void testVideoStitching2() {
        int result = new VideoStitching().videoStitching(new int[][]{{0, 1}, {1, 2}}, 5);
        assertEquals(result, -1);
    }

    @Test
    public void testVideoStitching3() {
        int result = new VideoStitching().videoStitching(new int[][]{{0, 1}, {6, 8}, {0, 2}, {5, 6}, {0, 4}, {0, 3}, {6, 7}, {1, 3}, {4, 7}, {1, 4}, {2, 5}, {2, 6}, {3, 4}, {4, 5}, {5, 7}, {6, 9}}, 9);
        assertEquals(result, 3);
    }

    @Test
    public void testVideoStitching4() {
        int result = new VideoStitching().videoStitching(new int[][]{{0, 4}, {2, 8}}, 5);
        assertEquals(result, 2);
    }

    @Test
    public void testVideoStitching5() {
        int result = new VideoStitching().videoStitching(new int[][]{{0, 2}, {4, 8}}, 8);
        assertEquals(result, -1);
    }

}