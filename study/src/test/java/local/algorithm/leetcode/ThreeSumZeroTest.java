package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.List;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/17 0:29
 */
public class ThreeSumZeroTest {

    @Test
    public void testThreeSum() {
        List<List<Integer>> result = new ThreeSumZero().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(result);

        result = new ThreeSumZero().threeSum(new int[]{0, 0, 0, 0});
        System.out.println(result);

        result = new ThreeSumZero().threeSum(new int[]{-2, 0, 1, 1, 2});
        System.out.println(result);
    }
}