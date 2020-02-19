package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @author cuixiaoshuang
 * @date 2020-02-19
 **/
public class DailyTemperaturesTest {

    @Test
    public void testDailyTemperatures1() {
        int[] result = new DailyTemperatures().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testDailyTemperatures2() {
        int[] result = new DailyTemperatures().dailyTemperatures(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testDailyTemperatures3() {
        int[] result = new DailyTemperatures().dailyTemperatures(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1});
        System.out.println(Arrays.toString(result));
    }
}
