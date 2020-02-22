package local.algorithm.leetcode;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2020-02-22
 **/
public class FindLongestWordTest {

    @Test
    public void testFindLongestWord() {
        String result = new FindLongestWord().findLongestWord("abpcplea", Lists.newArrayList("ale","apple","monkey","plea"));
        assertEquals(result, "apple");
    }

    @Test
    public void testContains1() {
        boolean result = new FindLongestWord().contains("", "");
        assertTrue(result);
    }

    @Test
    public void testContains2() {
        boolean result = new FindLongestWord().contains("abpcplea", "apple");
        assertTrue(result);
    }

    @Test
    public void testContains3() {
        boolean result = new FindLongestWord().contains("abpcplea", "applee");
        assertFalse(result);
    }
}