package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/5 13:03
 */
public class SortArrayByParityTest {

    @Test
    public void testSortArrayByParity() {
        int[] data = {3, 1, 2, 4};
        int[] result = new SortArrayByParity().sortArrayByParity(data);
        System.out.println(Arrays.toString(result));
    }
}