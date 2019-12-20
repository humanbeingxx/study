package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2019-12-20
 **/
public class CountDigitOneTest {

    @Test
    public void testForce() {
        System.out.println(new CountDigitOne().force(0, 1));
        System.out.println(new CountDigitOne().force(0, 10));
        System.out.println(new CountDigitOne().force(0, 100));
        System.out.println(new CountDigitOne().force(0, 1000));
        System.out.println(new CountDigitOne().force(0, 10000));
        System.out.println(new CountDigitOne().force(100, 200));
        System.out.println(new CountDigitOne().force(200, 300));
    }
}