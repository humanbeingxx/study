package local.utils;

import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-01-09
 **/
public class FileSplitUtilsTest {

    @Test
    public void testGetFileSuffix() {
        assertEquals(FileSplitUtils.getFileSuffix("abc.txt"), "txt");
        assertEquals(FileSplitUtils.getFileSuffix("abc.txt.sql"), "txt.sql");
        assertEquals(FileSplitUtils.getFileSuffix("abc"), "");
    }

    @Test
    public void testSplitFile() throws IOException {
        FileSplitUtils.splitFile("/Users/cxs/temp/diff_output.txt", "/Users/cxs/temp/diff_output_split", 10 * 1024 * 1024);
    }

    @Test
    public void testMergeFile() throws IOException {
        FileSplitUtils.mergeFile(Lists.newArrayList(
                "/Users/cxs/temp/diff_output_split_000.txt",
                "/Users/cxs/temp/diff_output_split_001.txt",
                "/Users/cxs/temp/diff_output_split_002.txt",
                "/Users/cxs/temp/diff_output_split_003.txt",
                "/Users/cxs/temp/diff_output_split_004.txt",
                "/Users/cxs/temp/diff_output_split_005.txt",
                "/Users/cxs/temp/diff_output_split_006.txt",
                "/Users/cxs/temp/diff_output_split_007.txt",
                "/Users/cxs/temp/diff_output_split_008.txt",
                "/Users/cxs/temp/diff_output_split_009.txt",
                "/Users/cxs/temp/diff_output_split_010.txt",
                "/Users/cxs/temp/diff_output_split_011.txt",
                "/Users/cxs/temp/diff_output_split_012.txt",
                "/Users/cxs/temp/diff_output_split_013.txt",
                "/Users/cxs/temp/diff_output_split_014.txt",
                "/Users/cxs/temp/diff_output_split_015.txt",
                "/Users/cxs/temp/diff_output_split_016.txt",
                "/Users/cxs/temp/diff_output_split_017.txt",
                "/Users/cxs/temp/diff_output_split_018.txt",
                "/Users/cxs/temp/diff_output_split_019.txt",
                "/Users/cxs/temp/diff_output_split_020.txt"
                ),
                "/Users/cxs/temp/diff_output_merge.txt");
    }
}