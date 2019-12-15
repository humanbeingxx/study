package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/15 15:33
 */
public class MinDiffTest {

    @Test
    public void testMinimumAbsDifference() {
        List<List<Integer>> result = new MinDiff().minimumAbsDifference(new int[]{40, 11, 26, 27, -20});
        System.out.println(result);
    }
}