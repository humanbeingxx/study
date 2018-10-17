package local.algorithm;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static local.algorithm.ExhaustCombination.copy;

/**
 * @author xiaoshuang.cui
 * @date 2018/10/17 上午10:29
 **/
public class ExhaustCombinationTest {

    @Test
    public void testExhaust0() {
        int[] data = {};
        List<int[]> result = ExhaustCombination.exhaust(data);

        print(result);
        Assert.assertEquals(result.size(), 0);

    }

    @Test
    public void testExhaust() {
        int[] data = {1, 2, 3};
        List<int[]> result = ExhaustCombination.exhaust(data);

        print(result);
        Assert.assertEquals(result.size(), 6);

    }

    @Test
    public void testExhaust2() {
        int[] data = {1};
        List<int[]> result = ExhaustCombination.exhaust(data);

        print(result);
        Assert.assertEquals(result.size(), 1);

    }

    @Test
    public void testExhaust3() {
        int[] data = {1, 2};
        List<int[]> result = ExhaustCombination.exhaust(data);

        print(result);
        Assert.assertEquals(result.size(), 3);

    }

    @Test
    public void testExhaust4() {
        int[] data = {1, 2, 3, 4};
        List<int[]> result = ExhaustCombination.exhaust(data);

        print(result);
        Assert.assertEquals(result.size(), 10);

    }

    private void print(List<int[]> data) {
        for (int[] datum : data) {
            System.out.println(Arrays.toString(datum));
        }
    }

    @Test
    public void testCopy() {
        int[] a = {1, 2, 3, 4, 5};

        int[] result = copy(a, 2, 4);

        Assert.assertEquals(result, new int[]{3, 4, 5});
    }

    @Test
    public void testCopy2() {
        int[] a = {1, 2, 3, 4, 5};

        int[] result = copy(a, 0, 0);

        Assert.assertEquals(result, new int[]{1});
    }
}