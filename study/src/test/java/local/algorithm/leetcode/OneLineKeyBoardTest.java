package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/1 14:59
 */
public class OneLineKeyBoardTest {

    @Test
    public void testFindWords() {
        String[] result = new OneLineKeyBoard().findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"});
        assertEquals(result, new String[]{"Alaska", "Dad"});
    }
}