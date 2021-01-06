package local.algorithm.leetcode.lcof;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/12 16:02
 */
public class TranslateNumTest {

    @Test
    public void testTranslateNum0() {
        int result = new TranslateNum().translateNum(0);
        assertEquals(result, 1);
    }

    @Test
    public void testTranslateNum1() {
        int result = new TranslateNum().translateNum(12258);
        assertEquals(result, 5);
    }

    @Test
    public void testTranslateNum2() {
        int result = new TranslateNum().translateNum(1234567890);
        assertEquals(result, 3);
    }

    @Test
    public void testTranslateNum3() {
        int result = new TranslateNum().translateNum(1111111111);
        assertEquals(result, 89);
    }

    @Test
    public void testTranslateNum4() {
        int result = new TranslateNum().translateNum(506);
        assertEquals(result, 1);
    }
}