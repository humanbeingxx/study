package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class JudgeSquareSumTest {

    @Test
    public void testJudgeSquareSum1() {
        boolean result = new JudgeSquareSum().judgeSquareSum(116);
        assertTrue(result);
    }

    @Test
    public void testJudgeSquareSum2() {
        boolean result = new JudgeSquareSum().judgeSquareSum(1000000000);
        assertTrue(result);
    }
}