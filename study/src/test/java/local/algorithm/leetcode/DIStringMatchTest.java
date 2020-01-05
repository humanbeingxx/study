package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-01-03
 **/
public class DIStringMatchTest {

    @Test
    public void testDiStringMatch() {
        int[] result = new DIStringMatch().diStringMatch("IDID");
        assertEquals(result, new int[]{0, 4, 1, 3, 2});

        result = new DIStringMatch().diStringMatch("III");
        assertEquals(result, new int[]{0, 1, 2, 3});
    }
}