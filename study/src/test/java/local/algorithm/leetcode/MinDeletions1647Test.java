package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MinDeletions1647Test {

    @Test
    public void testMinDeletions1() {
        int result = new MinDeletions1647().minDeletions("ceabaacb");
        assertEquals(result, 2);
    }

    @Test
    public void testMinDeletions2() {
        int result = new MinDeletions1647().minDeletions("aaabbbcc");
        assertEquals(result, 2);
    }

    @Test
    public void testMinDeletions3() {
        int result = new MinDeletions1647().minDeletions("aaaabbbbccccddddeeeeffghijk");
        assertEquals(result, 17);
    }

    @Test
    public void testMinDeletions4() {
        int result = new MinDeletions1647().minDeletions("bbcebab");
        assertEquals(result, 2);
    }
}