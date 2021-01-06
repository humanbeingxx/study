package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.assertTrue;

public class LongestHappyStringTest {

    @Test
    public void testLongestDiverseString1() {
        String result = new LongestHappyString().longestDiverseString(7, 1, 1);
        check(result);
    }

    @Test
    public void testLongestDiverseString2() {
        String result = new LongestHappyString().longestDiverseString(7, 1, 0);
        check(result);
    }

    @Test
    public void testLongestDiverseString3() {
        String result = new LongestHappyString().longestDiverseString(2, 2, 1);
        check(result);
    }

    @Test
    public void testLongestDiverseStringRandom() {
        Random random = new Random();
        int a = random.nextInt(100);
        int b = random.nextInt(100);
        int c = random.nextInt(100);
        System.out.println(a + " " + b + " " + c);
        String result = new LongestHappyString().longestDiverseString(a, b, c);
        System.out.println(result);
        check(result);
    }

    private void check(String target) {
        char previous = ' ', count = 0;
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            if (count == 0) {
                count = 1;
                previous = c;
            } else if (previous == c) {
                count++;
            } else {
                previous = c;
                count = 1;
            }
            assertTrue(count <= 2);
        }

    }
}