package local.algorithm;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class FindKClosestElementsTest {

    @Test
    public void testFindClosestElements1() {
        List<Integer> result = new FindKClosestElements().findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3);
        System.out.println(result);
    }

    @Test
    public void testFindClosestElements2() {
        List<Integer> result = new FindKClosestElements().findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 0);
        System.out.println(result);
    }

    @Test
    public void testFindClosestElements3() {
        List<Integer> result = new FindKClosestElements().findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 6);
        System.out.println(result);
    }

    @Test
    public void testFindClosestElements4() {
        List<Integer> result = new FindKClosestElements().findClosestElements(new int[]{1}, 1, 1);
        System.out.println(result);
    }
}