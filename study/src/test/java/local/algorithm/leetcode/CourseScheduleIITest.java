package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CourseScheduleIITest {

    @Test
    public void testFindOrder0() {
        int[] result = new CourseScheduleII().findOrder(4, new int[][]{{1, 2}, {2, 1}});
        assertEquals(result, new int[0]);
    }

    @Test
    public void testFindOrder1() {
        int[] result = new CourseScheduleII().findOrder(2, new int[][]{{1, 0}});
        assertEquals(result, new int[]{0, 1});
    }

    @Test
    public void testFindOrder2() {
        int[] result = new CourseScheduleII().findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
        assertEquals(result, new int[]{0, 1, 2, 3});
    }

    @Test
    public void testFindOrder20() {
        int[] result = new CourseScheduleII().findOrder(4, new int[][]{{1, 2}, {2, 1}});
        assertEquals(result, new int[0]);
    }

    @Test
    public void testFindOrder21() {
        int[] result = new CourseScheduleII().findOrder(2, new int[][]{{1, 0}});
        assertEquals(result, new int[]{0, 1});
    }

    @Test
    public void testFindOrder22() {
        int[] result = new CourseScheduleII().findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
        assertEquals(result, new int[]{0, 1, 2, 3});
    }
}