package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/22 16:05
 */
public class AlienSortedTest {

    @Test
    public void testIsOrdered1() {
        boolean result = new AlienSorted().isOrdered("abc", "abc", new int[]{0, 1, 2});
        assertTrue(result);
    }

    @Test
    public void testIsOrdered2() {
        boolean result = new AlienSorted().isOrdered("abc", "ab", new int[]{0, 1, 2});
        assertFalse(result);
    }

    @Test
    public void testIsOrdered3() {
        boolean result = new AlienSorted().isOrdered("acb", "abc", new int[]{0, 2, 1});
        assertTrue(result);
    }

    @Test
    public void testIsOrdered4() {
        boolean result = new AlienSorted().isOrdered("acbaaa", "abc", new int[]{0, 2, 1});
        assertTrue(result);
    }

    @Test
    public void testIsAlienSorted1() {
        boolean result = new AlienSorted().isAlienSorted(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz");
        assertTrue(result);
    }

    @Test
    public void testIsAlienSorted2() {
        boolean result = new AlienSorted().isAlienSorted(new String[]{"word","world","row"}, "worldabcefghijkmnpqstuvxyz");
        assertFalse(result);
    }

    @Test
    public void testIsAlienSorted3() {
        boolean result = new AlienSorted().isAlienSorted(new String[]{"apple","app"}, "abcdefghijklmnopqrstuvwxyz");
        assertFalse(result);
    }
}