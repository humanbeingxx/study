package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2020-01-20
 **/
public class AllSubsetsTest {

    @Test
    public void testSubsets() {
        List<List<Integer>> result = new AllSubsets().subsets(new int[]{1, 2, 3, 4, 5});
        result.forEach(System.out::println);
    }
}