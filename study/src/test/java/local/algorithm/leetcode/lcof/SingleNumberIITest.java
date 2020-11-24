package local.algorithm.leetcode.lcof;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SingleNumberIITest {

    @Test
    public void testSingleNumber() {
        int result = new SingleNumberII().singleNumber(new int[]{1, 2, 3, 4, 2, 3, 3, 2, 4, 4, -1, 1, 1});
        System.out.println(result);
    }
}