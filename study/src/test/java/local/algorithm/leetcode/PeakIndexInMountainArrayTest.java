package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-01-02
 **/
public class PeakIndexInMountainArrayTest {

    @Test
    public void testPeakIndexInMountainArray() {
        int result = new PeakIndexInMountainArray().peakIndexInMountainArray(new int[]{0, 2, 1, 0});
        assertEquals(result, 1);

        result = new PeakIndexInMountainArray().peakIndexInMountainArray(new int[]{1, 2, 3, 4});
        assertEquals(result, 3);

        result = new PeakIndexInMountainArray().peakIndexInMountainArray(new int[]{4, 3, 2, 1});
        assertEquals(result, 0);
    }
}