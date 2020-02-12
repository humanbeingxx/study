package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-02-12
 **/
public class GrayCodeTest {

    @Test
    public void testGrayCode() {
        List<Integer> result = new GrayCode().grayCode(10);
        HashSet<Integer> set = new HashSet<>(result);
        assertEquals(set.size(), (int) Math.pow(2, 10));
    }
}