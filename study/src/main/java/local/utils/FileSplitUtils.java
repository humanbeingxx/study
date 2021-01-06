package local.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2020-01-09
 **/
public class FileSplitUtils {

    public static void splitFile(String sourceFile, String target, int maxSize) throws IOException {
        File source = new File(sourceFile);
        if (!source.exists()) {
            return;
        }

        String fileSuffix = getFileSuffix(sourceFile);
        int suffixNum = 0, readLength = 0;
        byte[] buffer = new byte[maxSize];

        try (FileInputStream fis = new FileInputStream(sourceFile)) {
            File output = new File(target + String.format("_%03d", suffixNum) + "." + fileSuffix);
            while ((readLength = fis.read(buffer)) > 0) {
                writeBytes(output, buffer, readLength);
                suffixNum++;
                output = new File(target + String.format("_%03d", suffixNum) + "." + fileSuffix);
            }
        }
    }

    private static void writeBytes(File target, byte[] buffer, int len) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(target)) {
            fos.write(buffer, 0, len);
        }
    }

    static String getFileSuffix(String fileName) {
        String[] split = fileName.split("\\.", 2);
        if (split.length == 1) {
            return "";
        } else {
            return split[1];
        }
    }

    public static void mergeFile(List<String> sourceFiles, String target) throws IOException {
        File output = new File(target);
        output.delete();
        output.createNewFile();
        try (FileOutputStream fos = new FileOutputStream(target)) {
            for (String sourceFile : sourceFiles) {
                Files.copy(Paths.get(sourceFile), fos);
            }
        }
    }
}
