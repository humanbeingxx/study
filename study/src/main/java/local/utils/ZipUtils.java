package local.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * @author cuixiaoshuang
 * @date 2020-01-11
 **/
public class ZipUtils {

    public static void unzip(String src, String dst) throws IOException {
        if (!dst.endsWith("/")) {
            dst += "/";
        }
        try (ZipFile zipFile = new ZipFile(src, Charset.forName("UTF8"))) {
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry zipEntry = entries.nextElement();
                processEntry(zipFile, zipEntry, dst);

            }
        }

    }

    private static void processEntry(ZipFile zipFile, ZipEntry zipEntry, String dst) throws IOException {
        String entryName = zipEntry.getName();
        String outPath = (dst + entryName).replace("/", File.separator);
        File file = new File(outPath.substring(0, outPath.lastIndexOf(File.separator)));
        if (!file.exists()) {
            file.mkdirs();
        }
        if (new File(outPath).isDirectory()) {
            return;
        }
        try (InputStream is = zipFile.getInputStream(zipEntry); FileOutputStream fos = new FileOutputStream(outPath)) {
            byte[] buf = new byte[2048];
            int len;
            while ((len = is.read(buf)) > 0) {
                fos.write(buf, 0, len);
            }
        }
    }
}
