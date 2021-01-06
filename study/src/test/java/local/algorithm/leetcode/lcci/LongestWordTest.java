package local.algorithm.leetcode.lcci;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/19 21:06
 */
public class LongestWordTest {

    @Test
    public void testLongestWord1() {
        String result = new LongestWord().longestWord(new String[]{"cat", "dogwalkerwalker", "dogwalkerwalkerer", "banana", "dog", "nana", "walk", "walker", "dogwalker"});
        assertEquals(result, "dogwalkerwalker");
    }

    @Test
    public void testLongestWord2() {
        String result = new LongestWord().longestWord(new String[]{"llllcccl", "clclll", "ccc", "llccllccl", "lcclccclcl", "c"});
        assertEquals(result, "ccc");
    }
}