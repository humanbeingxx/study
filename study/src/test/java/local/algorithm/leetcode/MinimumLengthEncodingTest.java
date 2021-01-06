package local.algorithm.leetcode;

import org.testng.annotations.Test;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/5/28 1:13
 */
public class MinimumLengthEncodingTest {

    @Test
    public void testConstructTree() {
        MinimumLengthEncoding.Node tree = new MinimumLengthEncoding().constructTree(new String[]{"time", "me", "bell"});
        System.out.println(tree);
    }

    @Test
    public void testMinimumLengthEncoding() {
        int len = new MinimumLengthEncoding().minimumLengthEncoding(new String[]{"time", "me", "bell"});
        System.out.println(len);
    }
}