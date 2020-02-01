package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-02-01
 **/
public class HIndexTest {

    @Test
    public void testHIndex1() {
        int result = new HIndex().hIndex(new int[]{3, 0, 6, 1, 5});
        assertEquals(result, 3);
    }

    @Test
    public void testHIndex2() {
        int result = new HIndex().hIndex(new int[]{0, 0, 0});
        assertEquals(result, 0);
    }

    @Test
    public void testHIndex3() {
        int result = new HIndex().hIndex(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        assertEquals(result, 5);
    }

    @Test
    public void testHIndex4() {
        int result = new HIndex().hIndex(new int[]{0});
        assertEquals(result, 0);
    }

    @Test
    public void testHIndex5() {
        int result = new HIndex().hIndex(new int[]{1});
        assertEquals(result, 1);
    }
}