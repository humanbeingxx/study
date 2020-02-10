package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2020-02-10
 **/
public class CombinationSumIITest {

    @Test
    public void testCombinationSum2_1() {
        List<List<Integer>> result = new CombinationSumII().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        result.forEach(System.out::println);
    }

    @Test
    public void testCombinationSum_2() {
        List<List<Integer>> result = new CombinationSumII().combinationSum2(new int[]{2, 5, 2, 1, 2}, 5);
        result.forEach(System.out::println);
    }
}