package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-02-10
 **/
public class FindPeakElementTest {

    @Test
    public void testFindPeakElement1() {
        int result = new FindPeakElement().findPeakElement(new int[]{2, 1});
        assertEquals(result, 0);
    }

    @Test
    public void testFindPeakElement2() {
        int result = new FindPeakElement().findPeakElement(new int[]{2, 1, 2});
        assertEquals(result, 0);
    }
}