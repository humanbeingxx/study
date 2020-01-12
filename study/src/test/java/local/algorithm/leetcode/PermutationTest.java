package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/13 0:40
 */
public class PermutationTest {

    @Test
    public void testPermute() {
        List<List<Integer>> result = new Permutation().permute(new int[]{1,2,3,4,5});
        assertEquals(result.size(), 120);
    }
}