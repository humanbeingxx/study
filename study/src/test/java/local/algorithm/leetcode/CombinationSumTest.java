package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2020-02-10
 **/
public class CombinationSumTest {

    @Test
    public void testCombinationSum1() {
        List<List<Integer>> result = new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7);
        result.forEach(System.out::println);
    }

    @Test
    public void testCombinationSum2() {
        List<List<Integer>> result = new CombinationSum().combinationSum(new int[]{2, 3, 5}, 8);
        result.forEach(System.out::println);
    }
}