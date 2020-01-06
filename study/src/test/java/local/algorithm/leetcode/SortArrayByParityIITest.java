package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @author cuixiaoshuang
 * @date 2020-01-06
 **/
public class SortArrayByParityIITest {

    @Test
    public void testSortArrayByParityII() {
        int[] result = new SortArrayByParityII().sortArrayByParityII(new int[]{4, 2});
        System.out.println(Arrays.toString(result));
    }
}