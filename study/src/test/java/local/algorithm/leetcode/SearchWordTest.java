package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * @author cuixiaoshuang
 * @date 2020-01-28
 **/
public class SearchWordTest {

    @Test
    public void testExist() {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        boolean result = new SearchWord().exist(board, "ABCCED");
        assertTrue(result);

        result = new SearchWord().exist(board, "SEE");
        assertTrue(result);

        result = new SearchWord().exist(board, "ABCB");
        assertFalse(result);
    }
}