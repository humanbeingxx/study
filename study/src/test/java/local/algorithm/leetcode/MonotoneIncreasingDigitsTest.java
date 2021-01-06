package local.algorithm.leetcode;

import org.testng.annotations.Test;

public class MonotoneIncreasingDigitsTest {

    @Test
    public void testMonotoneIncreasingDigits1() {
        int result = new MonotoneIncreasingDigits().monotoneIncreasingDigits(213213);
        System.out.println(result);
    }

    @Test
    public void testMonotoneIncreasingDigits2() {
        int result = new MonotoneIncreasingDigits().monotoneIncreasingDigits(110);
        System.out.println(result);
    }

    @Test
    public void testMonotoneIncreasingDigits3() {
        int result = new MonotoneIncreasingDigits().monotoneIncreasingDigits(1234);
        System.out.println(result);
    }

    @Test
    public void testMonotoneIncreasingDigits4() {
        int result = new MonotoneIncreasingDigits().monotoneIncreasingDigits(10000000);
        System.out.println(result);
    }
}