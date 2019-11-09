package local.other;

import com.google.common.io.CharSink;
import com.google.common.io.FileWriteMode;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

import static com.google.common.io.Files.asCharSink;

/**
 * @author cuixiaoshuang
 * @date 2019-05-24
 **/
public class ReadFilesTest {

    @Test
    public void testGenerateFile() throws IOException {
        for (int i = 0; i < 100; i++) {
            File f = new File("/Users/cxs/temp/test_read_files/file_" + i);
            CharSink charSink = asCharSink(f, Charset.defaultCharset(), FileWriteMode.APPEND);
            for (int j = 0; j < 5000000; j++) {
                charSink.write("this is a test file for multi thread read\n");
            }
        }
    }

    @Test
    public void testReadSingle() {
        long startTime = System.currentTimeMillis();
        File directory = new File("/Users/cxs/temp/test_read_files");
        Arrays.stream(directory.listFiles()).forEach(file -> {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));) {
                while (bufferedReader.readLine() != null) {

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        System.out.println(System.currentTimeMillis() - startTime);
    }

    @Test
    public void testReadMulti() {
        long startTime = System.currentTimeMillis();
        File directory = new File("/Users/cxs/temp/test_read_files");
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "2");
        Arrays.asList(directory.listFiles()).parallelStream().forEach(file -> {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                while (bufferedReader.readLine() != null) {

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
