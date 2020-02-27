package local.algorithm.leetcode;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-02-25
 **/
public class SpiralOrderTest {

    @Test
    public void testSpiralOrder1() {
        List<Integer> result = new SpiralOrder().spiralOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
        assertEquals(result, Lists.newArrayList(1, 2, 3, 6, 9, 8, 7, 4, 5));
    }

    @Test
    public void testSpiralOrder2() {
        List<Integer> result = new SpiralOrder().spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        });
        assertEquals(result, Lists.newArrayList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7));
    }

    @Test
    public void testSpiralOrder3() {
        List<Integer> result = new SpiralOrder().spiralOrder(new int[][]{
                {1, 2, 3, 4}
        });
        assertEquals(result, Lists.newArrayList(1, 2, 3, 4));
    }
}