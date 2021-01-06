package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * @author cuixiaoshuang
 * @date 2019-12-23
 **/
public class DetectCapitalUseTest {

    @Test
    public void testDetectCapitalUse() {
        boolean result = new DetectCapitalUse().detectCapitalUse("Flag");
        assertTrue(result);
        result = new DetectCapitalUse().detectCapitalUse("F");
        assertTrue(result);
        result = new DetectCapitalUse().detectCapitalUse("a");
        assertTrue(result);
        result = new DetectCapitalUse().detectCapitalUse("FLAG");
        assertTrue(result);
        result = new DetectCapitalUse().detectCapitalUse("FlaG");
        assertFalse(result);
        result = new DetectCapitalUse().detectCapitalUse("FLag");
        assertFalse(result);
    }
}