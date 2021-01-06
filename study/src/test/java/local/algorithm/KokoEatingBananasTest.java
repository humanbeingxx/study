package local.algorithm;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class KokoEatingBananasTest {

    @Test
    public void testMinEatingSpeed1() {
        int result = new KokoEatingBananas().minEatingSpeed(new int[]{3, 6, 7, 11}, 8);
        assertEquals(result, 4);
    }

    @Test
    public void testMinEatingSpeed2() {
        int result = new KokoEatingBananas().minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5);
        assertEquals(result, 30);
    }

    @Test
    public void testMinEatingSpeed3() {
        int result = new KokoEatingBananas().minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6);
        assertEquals(result, 23);
    }

    @Test
    public void testMinEatingSpeed5() {
        int result = new KokoEatingBananas().minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 1000000);
        assertEquals(result, 1);
    }

    @Test
    public void testMinEatingSpeed4() {
        int result = new KokoEatingBananas().minEatingSpeed(new int[]{332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077, 337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728, 941802184}, 823855818);
        assertEquals(result, 14);
    }
}