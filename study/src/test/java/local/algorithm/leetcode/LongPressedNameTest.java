package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * @author cuixiaoshuang
 * @date 2020-01-02
 **/
public class LongPressedNameTest {

    @Test
    public void testIsLongPressedName() {
        boolean result = new LongPressedName().isLongPressedName("alex", "aaleex");
        assertTrue(result);

        result = new LongPressedName().isLongPressedName("saeed", "ssaaedd");
        assertFalse(result);

        result = new LongPressedName().isLongPressedName("leelee", "lleeelee");
        assertTrue(result);

        result = new LongPressedName().isLongPressedName("laiden", "laiden");
        assertTrue(result);
    }
}