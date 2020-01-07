package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-01-07
 **/
public class TictactoeTest {

    @Test
    public void testTictactoe() {
        String result = new Tictactoe().tictactoe(new int[][]{{0, 0}, {2, 0}, {1, 1}, {2, 1}, {2, 2}});
        assertEquals(result, "A");

        result = new Tictactoe().tictactoe(new int[][]{{0, 0}, {1, 1}, {0, 1}, {0, 2}, {1, 0}, {2, 0}});
        assertEquals(result, "B");

        result = new Tictactoe().tictactoe(new int[][]{{0, 0}, {1, 1}});
        assertEquals(result, "Pending");
    }
}