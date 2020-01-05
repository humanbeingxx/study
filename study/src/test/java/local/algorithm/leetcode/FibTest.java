package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/5 13:19
 */
public class FibTest {

    @Test
    public void testFib() {
        int result = new Fib().fib(30);
        assertEquals(result, 832040);

        result = new Fib().fib(0);
        assertEquals(result, 0);

        result = new Fib().fib(1);
        assertEquals(result, 1);

        result = new Fib().fib(2);
        assertEquals(result, 1);
    }
}