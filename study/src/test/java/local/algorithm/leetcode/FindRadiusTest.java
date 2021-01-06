package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/15 22:07
 */
public class FindRadiusTest {

    @Test
    public void testFindRadius1() {
        int radius = new FindRadius().findRadius(new int[]{1, 2, 3}, new int[]{2});
        Assert.assertEquals(radius, 1);
    }

    @Test
    public void testFindRadius2() {
        int radius = new FindRadius().findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4});
        Assert.assertEquals(radius, 1);
    }

    @Test
    public void testFindRadius3() {
        int radius = new FindRadius().findRadius(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 6});
        Assert.assertEquals(radius, 2);
    }

    @Test
    public void testFindRadius4() {
        int radius = new FindRadius().findRadius(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 2, 3, 4, 5, 6});
        Assert.assertEquals(radius, 0);
    }

    @Test
    public void testFindRadius5() {
        int radius = new FindRadius().findRadius(new int[]{1, 2, 3, 5, 15}, new int[]{2, 30});
        Assert.assertEquals(radius, 13);
    }

    @Test
    public void testFindRadius6() {
        int radius = new FindRadius().findRadius(new int[]{282475249, 622650073, 984943658, 144108930, 470211272, 101027544, 457850878, 458777923},
                new int[]{823564440, 115438165, 784484492, 74243042, 114807987, 137522503, 441282327, 16531729, 823378840, 143542612});
        Assert.assertEquals(radius, 161834419);
    }
}