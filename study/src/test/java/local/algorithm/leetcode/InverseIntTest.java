package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/15 16:59
 */
public class InverseIntTest {

    @Test
    public void testReverse() {
        System.out.println(new InverseInt().reverse(12345));
        System.out.println(new InverseInt().reverse(-12345));
        System.out.println(new InverseInt().reverse(Integer.MAX_VALUE));
        System.out.println(new InverseInt().reverse(Integer.MIN_VALUE));
        System.out.println(new InverseInt().reverse(1999999999));
    }
}