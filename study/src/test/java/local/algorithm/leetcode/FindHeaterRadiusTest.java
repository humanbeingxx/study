package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FindHeaterRadiusTest {

    @Test
    public void testFindRadius1() {
        int result = new FindHeaterRadius().findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4});
        assertEquals(result, 1);
    }

    @Test
    public void testFindRadius2() {
        int result = new FindHeaterRadius().findRadius(new int[]{1, 5}, new int[]{10});
        assertEquals(result, 9);
    }

    @Test
    public void testFindRadius3() {
        int result = new FindHeaterRadius().findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4});
        assertEquals(result, 1);
    }

    @Test
    public void testFindRadius4() {
        int result = new FindHeaterRadius().findRadius(new int[]{1}, new int[]{1,2,3,4});
        assertEquals(result, 0);
    }
}