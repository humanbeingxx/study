package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2020-01-27
 **/
public class CombineKFromNTest {

    @Test
    public void testCombine() {
        List<List<Integer>> result = new CombineKFromN().combine(4,3);
        result.forEach(System.out::println);
    }
}