package local.interview_internal_reference.byhunter;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class ChangeCoinTest {

    @Test
    public void testCoinChange1() {
        int result = new ChangeCoin().changeCoin(new int[]{1, 2, 5}, 11);
        assertEquals(result, 3);
    }

    @Test
    public void testCoinChange2() {
        int result = new ChangeCoin().changeCoin(new int[]{2}, 3);
        assertEquals(result, -1);
    }

    @Test
    public void testCoinChange3() {
        int result = new ChangeCoin().changeCoin(new int[]{1, 2}, 3);
        assertEquals(result, 2);
    }

    @Test
    public void testCoinChange4() {
        int result = new ChangeCoin().changeCoin(new int[]{1, Integer.MAX_VALUE}, 2);
        assertEquals(result, 2);
    }

    @Test
    public void testCoinChange5() {
        int result = new ChangeCoin().changeCoin(new int[]{1}, 1);
        assertEquals(result, 1);
    }

    @Test
    public void testCoinChange6() {
        int result = new ChangeCoin().changeCoin(new int[]{5, 2, 1}, 11);
        assertEquals(result, 3);
    }

    @Test
    public void testCoinChangeWithPath() {
        List<Integer> result = new ChangeCoin().changeCoinWithPath(new int[]{5, 2, 1}, 11);
        System.out.println(result);
    }
}