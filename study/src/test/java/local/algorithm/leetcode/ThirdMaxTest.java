package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/15 16:33
 */
public class ThirdMaxTest {

    @Test
    public void testThirdMax() {
        int result = new ThirdMax().thirdMax(new int[]{2, 2, 3, 1});
        System.out.println(result);

        result = new ThirdMax().thirdMax(new int[]{5, 2, 2});
        System.out.println(result);

        result = new ThirdMax().thirdMax(new int[]{2, 2});
        System.out.println(result);

        result = new ThirdMax().thirdMax(new int[]{2});
        System.out.println(result);

        result = new ThirdMax().thirdMax(new int[]{});
        System.out.println(result);

        result = new ThirdMax().thirdMax(new int[]{1,2,-2147483648});
        System.out.println(result);
    }
}