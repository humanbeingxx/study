package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FindMinTest {

    @Test
    public void testFindMin1() {
        int min = new FindMin().findMin(new int[]{4, 5, 6, 7, 0, 1, 2});
        assertEquals(min, 0);
    }

    @Test
    public void testFindMin2() {
        int min = new FindMin().findMin(new int[]{4, 5, 6, 7, 0});
        assertEquals(min, 0);
    }

    @Test
    public void testFindMin3() {
        int min = new FindMin().findMin(new int[]{4, 5, 6, 7});
        assertEquals(min, 4);
    }

    @Test
    public void testFindMin4() {
        int min = new FindMin().findMin(new int[]{4});
        assertEquals(min, 4);
    }

    @Test
    public void testFindMin5() {
        int min = new FindMin().findMin(new int[]{5, 1, 2, 3, 4});
        assertEquals(min, 1);
    }
}