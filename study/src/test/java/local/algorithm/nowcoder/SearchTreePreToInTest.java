package local.algorithm.nowcoder;

import org.testng.annotations.Test;

import java.util.Arrays;

public class SearchTreePreToInTest {

    @Test
    public void testPre2In1() {
        int[] result = new SearchTreePreToIn().pre2In(new int[]{5, 3, 1, 2, 4, 8, 7, 6, 9});
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testPre2In2() {
        int[] result = new SearchTreePreToIn().pre2In(new int[]{5, 3, 1, 4, 8, 7, 6, 9});
        System.out.println(Arrays.toString(result));
    }
}