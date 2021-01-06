package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Random;

public class NextGreaterElementsIITest {

    @Test
    public void testNextGreaterElements1() {
        int[] result = new NextGreaterElementsII().nextGreaterElements(new int[]{1, 2, 1});
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testNextGreaterElements2() {
        int[] result = new NextGreaterElementsII().nextGreaterElements(new int[]{6, 2, 3, 4, 5});
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testNextGreaterElements3() {
        int[] result = new NextGreaterElementsII().nextGreaterElements(new int[]{5});
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testNextGreaterElements4() {
        int[] result = new NextGreaterElementsII().nextGreaterElements(new int[]{5, 4, 3, 2, 1});
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void test() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            System.out.print(random.nextInt(100) + ",");
        }
    }
}