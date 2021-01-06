package local.algorithm.leetcode;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CanVisitAllRoomsTest {

    @Test
    public void testCanVisitAllRooms1() {
        boolean result = new CanVisitAllRooms().canVisitAllRooms(
                Lists.newArrayList(
                        Lists.newArrayList(1),
                        Lists.newArrayList(2),
                        Lists.newArrayList(3),
                        Lists.newArrayList()
                )
        );
        assertTrue(result);
    }

    @Test
    public void testCanVisitAllRooms2() {
        boolean result = new CanVisitAllRooms().canVisitAllRooms(
                Lists.newArrayList(
                        Lists.newArrayList(1, 3),
                        Lists.newArrayList(3, 0, 1),
                        Lists.newArrayList(2),
                        Lists.newArrayList(0)
                )
        );
        assertFalse(result);
    }
}