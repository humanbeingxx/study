package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2020-02-13
 **/
public class CombinationSumIIITest {

    @Test
    public void testCombinationSum3_1() {
        List<List<Integer>> result = new CombinationSumIII().combinationSum3(3,7);
        result.forEach(System.out::println);
    }

    @Test
    public void testCombinationSum3_2() {
        List<List<Integer>> result = new CombinationSumIII().combinationSum3(3,9);
        result.forEach(System.out::println);
    }
}