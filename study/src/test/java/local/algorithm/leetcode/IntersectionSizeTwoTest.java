package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/26 1:11
 */
public class IntersectionSizeTwoTest {

    @Test
    public void testIntersectionSizeTwo() {
        int result = new IntersectionSizeTwo().intersectionSizeTwo(new int[][]{{1, 3}, {1, 4}, {2, 5}, {3, 5}});
        assertEquals(result, 3);

        result = new IntersectionSizeTwo().intersectionSizeTwo(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}});
        assertEquals(result, 5);

        result = new IntersectionSizeTwo().intersectionSizeTwo(new int[][]{{1, 2}, {4, 5}});
        assertEquals(result, 4);
    }
}