package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/5 16:14
 */
public class PermutationStringTest {

    @Test
    public void testPermutation1() {
        String[] result = new PermutationString().permutation("abcd");
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testPermutation2() {
        String[] result = new PermutationString().permutation("aab");
        System.out.println(Arrays.toString(result));
    }
}