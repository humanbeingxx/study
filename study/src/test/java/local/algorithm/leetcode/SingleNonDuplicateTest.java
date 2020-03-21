package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SingleNonDuplicateTest {

    @Test
    public void testSingleNonDuplicate1() {
        int result = new SingleNonDuplicate().singleNonDuplicate(new int[]{1, 1, 2});
        assertEquals(result, 2);
    }

    @Test
    public void testSingleNonDuplicate2() {
        int result = new SingleNonDuplicate().singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8});
        assertEquals(result, 2);
    }

    @Test
    public void testSingleNonDuplicate3() {
        int result = new SingleNonDuplicate().singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11});
        assertEquals(result, 10);
    }

    @Test
    public void testSingleNonDuplicate4() {
        int result = new SingleNonDuplicate().singleNonDuplicate(new int[]{1, 1, 2});
        assertEquals(result, 2);
    }

    @Test
    public void testSingleNonDuplicate5() {
        int result = new SingleNonDuplicate().singleNonDuplicate(new int[]{1, 2, 2});
        assertEquals(result, 1);
    }
}