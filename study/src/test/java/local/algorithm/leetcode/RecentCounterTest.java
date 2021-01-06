package local.algorithm.leetcode;

import org.testng.annotations.Test;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/21 22:14
 */
public class RecentCounterTest {

    @Test
    public void testPing() {
        RecentCounter counter = new RecentCounter();
        System.out.println(counter.ping(1));
        System.out.println(counter.ping(2));
        System.out.println(counter.ping(100));
        System.out.println(counter.ping(3001));
        System.out.println(counter.ping(3002));
    }
}