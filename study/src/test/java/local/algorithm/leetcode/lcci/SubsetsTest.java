package local.algorithm.leetcode.lcci;

import org.testng.annotations.Test;

import java.util.List;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/20 16:27
 */
public class SubsetsTest {

    @Test
    public void testSubsets() {
        List<List<Integer>> result = new Subsets().subsets(new int[]{1, 2, 3});
        result.forEach(System.out::println);
    }
}