package local.algorithm.leetcode;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2019-12-26
 **/
public class SelfDividingNumbersTest {

    @Test
    public void testCheck() {
        boolean result = new SelfDividingNumbers().check(22);
        assertTrue(result);

        result = new SelfDividingNumbers().check(128);
        assertTrue(result);

        result = new SelfDividingNumbers().check(127);
        assertFalse(result);
    }

    @Test
    public void testSelfDividingNumbers() {
        List<Integer> result = new SelfDividingNumbers().selfDividingNumbers(1, 22);
        assertEquals(result, Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22));

        result = new SelfDividingNumbers().selfDividingNumbers(-22, -1);
        assertEquals(result, Lists.newArrayList(-15, -12, -9, -6, -3));
    }
}