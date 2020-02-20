package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2020-02-20
 **/
public class SortColorsTest {

    @Test
    public void testSortColors() {
        int[] nums = {2, 0, 1};
        new SortColors().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}