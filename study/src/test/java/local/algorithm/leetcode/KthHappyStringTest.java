package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class KthHappyStringTest {

    @Test
    public void testGetHappyString1() {
        String result = new KthHappyString().getHappyString(1, 3);
        assertEquals(result, "c");
    }

    @Test
    public void testGetHappyString2() {
        String result = new KthHappyString().getHappyString(1, 4);
        assertEquals(result, "");
    }

    @Test
    public void testGetHappyString3() {
        String result = new KthHappyString().getHappyString(3, 9);
        assertEquals(result, "cab");
    }

    @Test
    public void testGetHappyString4() {
        String result = new KthHappyString().getHappyString(10, 100);
        assertEquals(result, "abacbabacb");
    }
}