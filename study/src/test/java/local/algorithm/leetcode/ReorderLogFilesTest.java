package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/17 21:25
 */
public class ReorderLogFilesTest {

    @Test
    public void testReorderLogFiles1() {
        String[] result = new ReorderLogFiles().reorderLogFiles(new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"});
        Assert.assertEquals(result, new String[]{"g1 act car", "a8 act zoo", "ab1 off key dog", "a1 9 2 3 1", "zo4 4 7"});
    }

    @Test
    public void testReorderLogFiles2() {
        String[] result = new ReorderLogFiles().reorderLogFiles(new String[]{"a1 9 2 3 1"});
        Assert.assertEquals(result, new String[]{"a1 9 2 3 1"});
    }

    @Test
    public void testReorderLogFiles3() {
        String[] result = new ReorderLogFiles().reorderLogFiles(new String[]{});
        Assert.assertEquals(result, new String[]{});
    }

    @Test
    public void testReorderLogFiles4() {
        String[] result = new ReorderLogFiles().reorderLogFiles(new String[]{"a1 9 2 3 1", "g1 act car", "g2 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"});
        Assert.assertEquals(result, new String[]{"g1 act car", "g2 act car", "a8 act zoo", "ab1 off key dog", "a1 9 2 3 1", "zo4 4 7"});
    }

}