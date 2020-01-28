package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2020-01-28
 **/
public class ReorganizeStringTest {

    @Test
    public void testReorganizeString() {
        String result = new ReorganizeString().reorganizeString("aab");
        System.out.println(result);
    }
}