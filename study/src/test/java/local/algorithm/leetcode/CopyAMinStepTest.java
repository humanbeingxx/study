package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CopyAMinStepTest {

    @Test
    public void testMinSteps1() {
        int result = new CopyAMinStep().minSteps(3);
        assertEquals(result, 3);
    }

    @Test
    public void testMinSteps2() {
        int result = new CopyAMinStep().minSteps(8);
        assertEquals(result, 6);
    }

    @Test
    public void testMinSteps3() {
        int result = new CopyAMinStep().minSteps(123);
        assertEquals(result, 44);
    }
}