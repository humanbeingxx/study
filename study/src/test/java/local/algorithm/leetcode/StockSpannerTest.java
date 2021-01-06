package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class StockSpannerTest {

    @Test
    public void test() {
        StockSpanner spanner = new StockSpanner();
        assertEquals(spanner.next(100), 1);
        assertEquals(spanner.next(80), 1);
        assertEquals(spanner.next(60), 1);
        assertEquals(spanner.next(70), 2);
        assertEquals(spanner.next(60), 1);
        assertEquals(spanner.next(75), 4);
        assertEquals(spanner.next(85), 6);
        assertEquals(spanner.next(85), 7);
    }
}