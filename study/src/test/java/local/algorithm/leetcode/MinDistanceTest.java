package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.*;

public class MinDistanceTest {

    private Random random = new Random();

    @Test
    public void testMinDistance() {
        int result = new MinDistance().minDistance("a", "ab");
        assertEquals(result, 1);
    }

    @Test
    public void testMinDistanceRandom() {
        String word1 = generate();
        String word2 = generate();
        int result = new MinDistance().minDistance(word1, word2);
        System.out.println(word1);
        System.out.println(word2);
        System.out.println(result);
    }

    private String generate() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 50; i++) {
            sb.append((char)(random.nextInt(26) + 'a'));
        }
        return sb.toString();
    }
}