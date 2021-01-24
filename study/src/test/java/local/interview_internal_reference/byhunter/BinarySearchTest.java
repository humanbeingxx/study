package local.interview_internal_reference.byhunter;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BinarySearchTest {

    @Test
    public void testSearchFloor1() {
        int result = BinarySearch.searchFloor(new int[]{1, 1, 2, 3, 3, 4, 4, 5, 5, 6}, 4);
        assertEquals(result, 5);
    }

    @Test
    public void testSearchFloor2() {
        int result = BinarySearch.searchFloor(new int[]{1, 1, 2, 3, 3, 5, 5, 6}, 4);
        assertEquals(result, 4);
    }

    @Test
    public void testSearchFloor3() {
        int result = BinarySearch.searchFloor(new int[]{4, 6}, 5);
        assertEquals(result, 0);

        result = BinarySearch.searchFloor(new int[]{4, 6}, 1);
        assertEquals(result, -1);

        result = BinarySearch.searchFloor(new int[]{4, 6}, 7);
        assertEquals(result, 1);

        result = BinarySearch.searchFloor(new int[]{1,1,1,1}, 1);
        assertEquals(result, 0);
    }

    @Test
    public void testSearchCeil1() {
        int result = BinarySearch.searchCeil(new int[]{1, 1, 2, 3, 3, 4, 4, 5, 5, 6}, 4);
        assertEquals(result, 6);
    }

    @Test
    public void testSearchCeil2() {
        int result = BinarySearch.searchCeil(new int[]{1, 1, 2, 3, 3, 5, 5, 6}, 4);
        assertEquals(result, 5);
    }

    @Test
    public void testSearchCeil3() {
        int result = BinarySearch.searchCeil(new int[]{4, 6}, 5);
        assertEquals(result, 1);

        result = BinarySearch.searchCeil(new int[]{4, 6}, 1);
        assertEquals(result, 0);

        result = BinarySearch.searchCeil(new int[]{4, 6}, 7);
        assertEquals(result, -1);

        result = BinarySearch.searchCeil(new int[]{1,1,1,1}, 1);
        assertEquals(result, 3);
    }
}