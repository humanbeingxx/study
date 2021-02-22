package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RandomPickWithWeightTest {

    @Test
    public void testPickIndex() {
        RandomPickWithWeight pickWithWeight = new RandomPickWithWeight(new int[]{1, 3});
        int result = pickWithWeight.pickIndex();
    }
}