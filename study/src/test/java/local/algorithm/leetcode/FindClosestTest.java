package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/8 20:52
 */
public class FindClosestTest {

    @Test
    public void testFindClosest1() {
        int result = new FindClosest().findClosest(new String[]{"I", "am", "a", "student", "from", "a", "university", "in", "a", "city"}, "a", "student");
        assertEquals(result, 1);
    }

    @Test
    public void testFindClosest2() {
        int result = new FindClosest().findClosest(new String[]{"I", "am", "a", "student", "from", "a", "university", "in", "a", "city"}, "city", "student");
        assertEquals(result, 6);
    }
}