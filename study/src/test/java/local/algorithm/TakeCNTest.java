package local.algorithm;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author xiaoshuang.cui
 * @date 2018/10/17 上午11:15
 **/
public class TakeCNTest {

    @Test
    public void testTakeC2() {
        List<int[]> result = TakeCN.takeC2(new int[]{1, 2, 3, 4});
        Assert.assertEquals(result.size(), 6);
    }

    @Test
    public void testTakeCN0() {
        List<int[]> result = TakeCN.takeCN(new int[]{1, 2, 3, 4}, 0);
        print(result);
        Assert.assertEquals(result.size(), 0);
    }

    @Test
    public void testTakeCN1() {
        List<int[]> result = TakeCN.takeCN(new int[]{1, 2, 3, 4}, 1);
        print(result);
        Assert.assertEquals(result.size(), 4);
    }

    @Test
    public void testTakeCN2() {
        List<int[]> result = TakeCN.takeCN(new int[]{1, 2, 3, 4}, 2);
        print(result);
        Assert.assertEquals(result.size(), 6);
    }

    @Test
    public void testTakeCN3() {
        List<int[]> result = TakeCN.takeCN(new int[]{1, 2, 3, 4}, 3);
        print(result);
        Assert.assertEquals(result.size(), 4);
    }

    @Test
    public void testTakeCN4() {
        List<int[]> result = TakeCN.takeCN(new int[]{1, 2, 3, 4}, 4);
        print(result);
        Assert.assertEquals(result.size(), 1);
    }

    @Test
    public void testTakeCN10() {
        int[] data = new int[20];
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            data[i] = Math.abs(random.nextInt(10000));
        }

        List<int[]> result = TakeCN.takeCN(data, 10);

        long expect = (factorN(20) / factorN(10)) / factorN(10);



        Assert.assertEquals(result.size(), expect);
    }

    private long factorN(long n) {
        long result = 1;
        for (long i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    private void print(List<int[]> data) {
        for (int[] datum : data) {
            System.out.println(Arrays.toString(datum));
        }
    }
}