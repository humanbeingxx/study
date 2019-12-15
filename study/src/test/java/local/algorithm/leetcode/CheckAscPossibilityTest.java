package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/16 1:27
 */
public class CheckAscPossibilityTest {

    @Test
    public void testCheckPossibility1() {
        boolean possibility = new CheckAscPossibility().checkPossibility(new int[]{3, 4, 2, 3});
        Assert.assertFalse(possibility);
    }

    @Test
    public void testCheckPossibility2() {
        boolean possibility = new CheckAscPossibility().checkPossibility(new int[]{4, 2, 3});
        Assert.assertTrue(possibility);
    }

    @Test
    public void testCheckPossibility3() {
        boolean possibility = new CheckAscPossibility().checkPossibility(new int[]{4, 2, 1});
        Assert.assertFalse(possibility);
    }

    @Test
    public void testCheckPossibility4() {
        boolean possibility = new CheckAscPossibility().checkPossibility(new int[]{1, 3, 2});
        Assert.assertTrue(possibility);
    }
}