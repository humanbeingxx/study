package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2020-02-08
 **/
public class CourseScheduleTest {

    @Test
    public void testCanFinish() {
        boolean result = new CourseSchedule().canFinish(3, new int[][]{{0, 1}});
        assertTrue(result);
    }
}