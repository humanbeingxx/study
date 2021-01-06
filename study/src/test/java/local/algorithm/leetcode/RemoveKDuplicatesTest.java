package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RemoveKDuplicatesTest {

    @Test
    public void testRemoveDuplicates1() {
        String result = new RemoveKDuplicates().removeDuplicates("abcd", 3);
        assertEquals(result, "abcd");
    }

    @Test
    public void testRemoveDuplicates2() {
        String result = new RemoveKDuplicates().removeDuplicates("deeedbbcccbdaa", 3);
        assertEquals(result, "aa");
    }

    @Test
    public void testRemoveDuplicates3() {
        String result = new RemoveKDuplicates().removeDuplicates("pbbcggttciiippooaais", 2);
        assertEquals(result, "ps");
    }
}