package local.before.d1103;

import local.algorithm.PrimeNumSum;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author humanbeingxx@sina.com
 * @date
 */
public class PrimeNumSumTest {

    @Test
    public void test() {
        long sum = PrimeNumSum.sum(20);
        Assert.assertEquals(sum, 77);
    }

    @Test
    public void test0() {
        long sum = PrimeNumSum.sum(0);
        Assert.assertEquals(sum, -1);
    }
}
