package local.algorithm.leetcode.lcci;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/19 17:16
 */
public class OneEditAwayTest {

    @Test
    public void testOneEditAway1() {
        boolean result = new OneEditAway().oneEditAway("abcde", "abde");
        assertTrue(result);
    }

    @Test
    public void testOneEditAway2() {
        boolean result = new OneEditAway().oneEditAway("abde", "abcde");
        assertTrue(result);
    }

    @Test
    public void testOneEditAway3() {
        boolean result = new OneEditAway().oneEditAway("abcde", "abdde");
        assertTrue(result);
    }

    @Test
    public void testOneEditAway4() {
        boolean result = new OneEditAway().oneEditAway("abdde", "abcde");
        assertTrue(result);
    }

    @Test
    public void testOneEditAway5() {
        boolean result = new OneEditAway().oneEditAway("abddf", "abcde");
        assertFalse(result);
    }

    @Test
    public void testOneEditAway6() {
        boolean result = new OneEditAway().oneEditAway("adde", "abcde");
        assertFalse(result);
    }

    @Test
    public void testOneEditAway7() {
        boolean result = new OneEditAway().oneEditAway("ab", "a");
        assertTrue(result);
    }
}