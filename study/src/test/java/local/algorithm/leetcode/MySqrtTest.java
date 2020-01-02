package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2020-01-02
 **/
public class MySqrtTest {

    @Test
    public void testMySqrt() {
        int result = new MySqrt().mySqrt(8);
        assertEquals(result, 2);

        result = new MySqrt().mySqrt(9);
        assertEquals(result, 3);

        result = new MySqrt().mySqrt(1024);
        assertEquals(result, 32);

        result = new MySqrt().mySqrt(1023);
        assertEquals(result, 31);


        result = new MySqrt().mySqrt(2147395599);
        assertEquals(result, 46339);
    }
}