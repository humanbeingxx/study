package local.utils;

import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2020-01-11
 **/
public class ZipUtilsTest {

    @Test
    public void testUnzip() throws IOException {
        ZipUtils.unzip("/Users/cxs/temp/local.zip", "/Users/cxs/temp/unzip_dir");
    }
}