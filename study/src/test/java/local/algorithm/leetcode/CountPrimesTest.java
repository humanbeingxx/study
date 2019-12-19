package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2019-12-19
 **/
public class CountPrimesTest {

    @Test
    public void testCountPrimes() {
        int result = new CountPrimes().countPrimes(10);
        Assert.assertEquals(result, 4);

        result = new CountPrimes().countPrimes(1);
        Assert.assertEquals(result, 0);

        result = new CountPrimes().countPrimes(2);
        Assert.assertEquals(result, 0);

        result = new CountPrimes().countPrimes(5);
        Assert.assertEquals(result, 2);

        result = new CountPrimes().countPrimes(499979);
        Assert.assertEquals(result, 41537);
    }
}