package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FindNthDigitTest {

    @Test
    public void testFindNthDigit1() {
        int result = new FindNthDigit().findNthDigit(1000);
        assertEquals(result, 3);
    }

    @Test
    public void testFindNthDigit2() {
        int result = new FindNthDigit().findNthDigit(1000000);
        assertEquals(result, 1);
    }

    @Test
    public void testFindNthDigit3() {
        int result = new FindNthDigit().findNthDigit(5);
        assertEquals(result, 5);
    }
}