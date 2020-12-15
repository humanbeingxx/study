package local.algorithm.leetcode.lcci;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/19 21:55
 */
public class PatternMatchingTest {

    @Test
    public void testPatternMatching1() {
        boolean result = new PatternMatching().patternMatching("abba", "dogcatcatdog");
        assertTrue(result);
    }

    @Test
    public void testPatternMatching2() {
        boolean result = new PatternMatching().patternMatching("abba", "dogcatcatfish");
        assertFalse(result);
    }

    @Test
    public void testPatternMatching3() {
        boolean result = new PatternMatching().patternMatching("aaaa", "dogcatcatdog");
        assertFalse(result);
    }

    @Test
    public void testPatternMatching4() {
        boolean result = new PatternMatching().patternMatching("abba", "dogdogdogdog");
        assertTrue(result);
    }
}