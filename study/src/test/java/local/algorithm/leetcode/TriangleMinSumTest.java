package local.algorithm.leetcode;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TriangleMinSumTest {

    @Test
    public void testMinimumTotal1() {
        int result = new TriangleMinSum().minimumTotal(
                Lists.newArrayList(
                        Lists.newArrayList(2),
                        Lists.newArrayList(2)
                )
        );
        assertEquals(result, 4);
    }

    @Test
    public void testMinimumTotal2() {
        int result = new TriangleMinSum().minimumTotal(
                Lists.newArrayList(
                        Lists.newArrayList(2),
                        Lists.newArrayList(3, 4),
                        Lists.newArrayList(6, 5, 7),
                        Lists.newArrayList(4, 1, 8, 3)
                )
        );
        assertEquals(result, 11);
    }

    @Test
    public void testMinimumTotal3() {
        int result = new TriangleMinSum().minimumTotal(
                Lists.newArrayList(
                        Lists.newArrayList(2, 3),
                        Lists.newArrayList(3, 4),
                        Lists.newArrayList(6, 5, 7),
                        Lists.newArrayList(4, 1, 8, 3)
                )
        );
        assertEquals(result, 11);
    }
}