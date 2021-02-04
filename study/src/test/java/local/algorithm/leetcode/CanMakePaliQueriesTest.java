package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.List;

public class CanMakePaliQueriesTest {

    @Test
    public void testCanMakePaliQueries() {
        List<Boolean> result = new CanMakePaliQueries().canMakePaliQueries("abcda", new int[][]{{3, 3, 0}, {1, 2, 0}, {0, 3, 1}, {0, 3, 2}, {0, 4, 1}});
        System.out.println(result);
    }

    @Test
    public void testCanMakePaliQueriesV2() {
        List<Boolean> result = new CanMakePaliQueries().canMakePaliQueries2("abcda", new int[][]{{3, 3, 0}, {1, 2, 0}, {0, 3, 1}, {0, 3, 2}, {0, 4, 1}});
        System.out.println(result);
    }

    @Test
    public void testCanMakePaliQueriesV2_2() {
        List<Boolean> result = new CanMakePaliQueries().canMakePaliQueries2("abcbcda", new int[][]{{1,4,0}});
        System.out.println(result);
    }

    @Test
    public void testCanMakePaliQueriesV3() {
        List<Boolean> result = new CanMakePaliQueries().canMakePaliQueries3("abcda", new int[][]{{3, 3, 0}, {1, 2, 0}, {0, 3, 1}, {0, 3, 2}, {0, 4, 1}});
        System.out.println(result);
    }

    @Test
    public void testNXOR() {
        byte a = 0b00011101, b = 0b00000000;
        System.out.println(a ^ b);
        System.out.println((byte) ~b);
        System.out.println(Integer.toBinaryString((byte) (a ^ ~b)).substring(24));
    }
}