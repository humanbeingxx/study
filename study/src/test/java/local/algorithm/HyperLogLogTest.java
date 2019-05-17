package local.algorithm;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang@ktzh.lvwan.com
 * @date 2019-05-07
 **/
public class HyperLogLogTest {

    @Test
    public void testCutByAccuracy() {
        int num = 0b11111111111111110000000000000000;
        int[] ints = HyperLogLog.cutByAccuracy(num, 16);
        System.out.println(Integer.toBinaryString(ints[0]));
        System.out.println(Integer.toBinaryString(ints[1]));
    }

    @Test
    public void testFindFirstOne() {
        int pos = HyperLogLog.findFirstOne(0b11111111111111110000000000000000);
        Assert.assertEquals(pos, 31);
    }

    @Test
    public void testUseIntegerToFind() {
        int leadingZeros = Integer.numberOfLeadingZeros(0b11111111111111110000000000000000);
        int trailingZeros = Integer.numberOfTrailingZeros(0b11111111111111110000000000000000);
        System.out.println(leadingZeros);
        System.out.println(trailingZeros);
    }

    @Test
    public void testHarmonicMean() {
        double mean = HyperLogLog.harmonicMean(new int[]{2,2,2,2,2,0});
        System.out.println(mean);
    }
}