package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2019-12-27
 **/
public class BullAndCowsTest {

    @Test
    public void testGetHint() {
        String result = new BullAndCows().getHint("1807", "7810");
        assertEquals(result, "1A3B");

        result = new BullAndCows().getHint("1234", "1234");
        assertEquals(result, "4A0B");

        result = new BullAndCows().getHint("1123", "0111");
        assertEquals(result, "1A1B");

        result = new BullAndCows().getHint("1234", "4321");
        assertEquals(result, "0A4B");

        result = new BullAndCows().getHint("1122", "1222");
        assertEquals(result, "3A0B");
    }
}