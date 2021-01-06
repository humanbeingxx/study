package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2019-12-20
 **/
public class CountDigitOneTest {

    CountDigitOne counter = new CountDigitOne();

    @Test
    public void testCountDigitOne1() {
        int result = counter.countDigitOne(1);
        assertEquals(result, 1);

        result = counter.countDigitOne(10);
        assertEquals(result, 2);

        result = counter.countDigitOne(100);
        assertEquals(result, 21);

        result = counter.countDigitOne(1000);
        assertEquals(result, 301);

        result = counter.countDigitOne(10000);
        assertEquals(result, 4001);

        System.out.println(counter.oneCount);
    }

    @Test
    public void testCountDigitOne2() {
        int result = counter.countDigitOne(5);
        assertEquals(result, 1);

        result = counter.countDigitOne(13);
        assertEquals(result, 6);

        result = counter.countDigitOne(20);
        assertEquals(result, 12);

        result = counter.countDigitOne(101);
        assertEquals(result, 23);

        result = counter.countDigitOne(321);
        assertEquals(result, 173);

        result = counter.countDigitOne(1011);
        assertEquals(result, 316);

        result = counter.countDigitOne(99212);
        assertEquals(result, 49845);

        result = counter.countDigitOne(1410065408);
        assertEquals(result, 1737167499);

        result = counter.countDigitOne(9999212);
        assertEquals(result, 6999845);
    }
}