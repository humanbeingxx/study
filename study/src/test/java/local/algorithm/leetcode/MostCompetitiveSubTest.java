package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MostCompetitiveSubTest {

    @Test
    public void testMostCompetitive1() {
        int[] result = new MostCompetitiveSub().mostCompetitive(new int[]{3, 5, 2, 6, 4, 5}, 2);
        assertEquals(result, new int[]{2, 4});
    }

    @Test
    public void testMostCompetitive2() {
        int[] result = new MostCompetitiveSub().mostCompetitive(new int[]{2, 4, 3, 3, 5, 4, 9, 6}, 4);
        assertEquals(result, new int[]{2, 3, 3, 4});
    }

    @Test
    public void testMostCompetitive3() {
        int[] data = {84, 10, 71, 23, 66, 61, 62, 64, 34, 41, 80, 25, 91, 43, 4, 75, 65, 13, 37, 41, 46, 90, 55, 8, 85, 61, 95, 71};
        System.out.println(data.length);
        int[] result = new MostCompetitiveSub().mostCompetitive(data, 24);
        assertEquals(result, new int[]{10,23,61,62,34,41,80,25,91,43,4,75,65,13,37,41,46,90,55,8,85,61,95,71});
    }
}