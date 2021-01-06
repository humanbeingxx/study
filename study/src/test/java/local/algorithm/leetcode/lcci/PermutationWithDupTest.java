package local.algorithm.leetcode.lcci;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/21 19:54
 */
public class PermutationWithDupTest {

    @Test
    public void testPermutation() {
        String[] result = new PermutationWithDup().permutation("aabbcc");
        System.out.println(Arrays.toString(result));
    }
}