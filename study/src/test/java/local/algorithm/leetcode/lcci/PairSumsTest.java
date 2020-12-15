package local.algorithm.leetcode.lcci;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class PairSumsTest {

    @Test
    public void testPairSums1() {
        List<List<Integer>> result = new PairSums().pairSums(new int[]{5, 6, 5, 6, 6, 6, 5, 5}, 10);
        System.out.println(result);
    }
}