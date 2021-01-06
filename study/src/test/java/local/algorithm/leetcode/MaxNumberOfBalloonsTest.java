package local.algorithm.leetcode;

import org.testng.annotations.Test;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/15 15:51
 */
public class MaxNumberOfBalloonsTest {

    @Test
    public void testMaxNumberOfBalloons() {
        int count = new MaxNumberOfBalloons().maxNumberOfBalloons("nlaebolko");
        System.out.println(count);
        count = new MaxNumberOfBalloons().maxNumberOfBalloons("loonbalxballpoon");
        System.out.println(count);
        count = new MaxNumberOfBalloons().maxNumberOfBalloons("leetcode");
        System.out.println(count);
    }
}