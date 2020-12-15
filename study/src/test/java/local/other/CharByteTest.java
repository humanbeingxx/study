package local.other;

import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class CharByteTest {

    @Test
    public void test() throws UnsupportedEncodingException {
        char c = 0x5b57;
        System.out.println(c);
        String s = "字";
        char[] charArray = s.toCharArray();
        System.out.println(charArray.length);
        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
        System.out.println(bytes.length);
        System.out.println(Integer.toBinaryString((bytes[0] << 16 & (Byte.MAX_VALUE << 16))
                | (bytes[1] << 8 & (Byte.MAX_VALUE << 8))
                | bytes[2] & Byte.MAX_VALUE));

        System.out.println(Integer.toBinaryString(bytes[0] & Byte.MAX_VALUE));
        System.out.println(Integer.toBinaryString(bytes[1] & Byte.MAX_VALUE));
        System.out.println(Integer.toBinaryString(bytes[2] & Byte.MAX_VALUE));
        System.out.println(Integer.toBinaryString(c));
        System.out.println(Integer.toHexString(0b11001010010110100010111));

        System.out.println("a".getBytes(StandardCharsets.UTF_8).length);
    }
}
