package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2019-12-23
 **/
public class IntersectArrayTest {

    @Test
    public void testIntersect1() {
        int[] result = new IntersectArray().intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        Assert.assertEquals(result, new int[]{2, 2});
    }

    @Test
    public void testIntersect2() {
        int[] result = new IntersectArray().intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
        Assert.assertEquals(result, new int[]{4, 9});
    }

    @Test
    public void testIntersect3() {
        int[] result = new IntersectArray().intersect(new int[]{1, 2, 2, 1, 2, 3, 2}, new int[]{2, 2, 3});
        Assert.assertEquals(result, new int[]{2, 2, 3});
    }

    @Test
    public void testIntersectSorted1() {
        int[] result = new IntersectArray().intersectSorted(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        Assert.assertEquals(result, new int[]{2, 2});
    }

    @Test
    public void testIntersectSorted2() {
        int[] result = new IntersectArray().intersectSorted(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
        Assert.assertEquals(result, new int[]{4, 9});
    }

    @Test
    public void testIntersectSorted3() {
        int[] result = new IntersectArray().intersectSorted(new int[]{1, 2, 2, 1, 2, 3, 2}, new int[]{2, 2, 3});
        Assert.assertEquals(result, new int[]{2, 2, 3});
    }
}