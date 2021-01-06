package local.algorithm.leetcode;

import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2020-02-21
 **/
public class NumIslandsTest {

    @Test
    public void testNumIslands1() {
        int result = new NumIslands().numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        });
        System.out.println(result);
    }

    @Test
    public void testNumIslands2() {
        int result = new NumIslands().numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        });
        System.out.println(result);
    }
}