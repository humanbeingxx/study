package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Random;

import static org.testng.Assert.*;

public class ContiguousArrayTest {

    @Test
    public void testFindMaxLength1() {
        int result = new ContiguousArray().findMaxLength(new int[]{0, 1});
        assertEquals(result, 2);
    }

    @Test
    public void testFindMaxLength2() {
        int result = new ContiguousArray().findMaxLength(new int[]{0,1,0,1,1,1,1,0,0,0,0,0,1,1,0});
        assertEquals(result, 2);
    }

    @Test
    public void testRandom() {
        int[] data = new int[100];
        Random random = new Random();
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt(2);
        }
        System.out.println(Arrays.toString(data));
    }
}