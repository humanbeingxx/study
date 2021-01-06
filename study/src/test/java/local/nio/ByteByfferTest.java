package local.nio;

import org.testng.annotations.Test;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * @author cuixiaoshuang
 * @date 2019-07-16
 **/
public class ByteByfferTest {

    @Test
    public void testWrite() {
        ByteBuffer buffer = ByteBuffer.allocate(100);
        buffer.put("123456789".getBytes());
        System.out.println(buffer.position());
        System.out.println(buffer.limit());

        byte[] bytes = new byte[9];
        buffer.flip();
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        buffer.get(bytes);
        System.out.println(new String(bytes, StandardCharsets.UTF_8));
    }

    @Test
    public void testCompact() {
        ByteBuffer buffer = ByteBuffer.allocate(100);
        buffer.put("123456789".getBytes());

        buffer.flip();
        System.out.println(buffer.position());
        System.out.println(buffer.limit());

        buffer.compact();
        System.out.println(buffer.position());
        System.out.println(buffer.limit());

        buffer.flip();
        buffer.clear();

        System.out.println(buffer.position());
        System.out.println(buffer.limit());

        buffer.put("123456789".getBytes());
        buffer.compact();

        //这里出现问题
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.remaining());

        buffer.compact();

        System.out.println(buffer.position());
        System.out.println(buffer.limit());
    }

    @Test
    public void testIncompleteWrite() {
        ByteBuffer buffer = ByteBuffer.allocate(100);
        buffer.clear();

        byte[] bytes = new byte[3];
        for (int i = 0; i < 5; i++) {
            buffer.put("12345".getBytes());
            buffer.flip();
            buffer.get(bytes);
            System.out.println(new String(bytes, StandardCharsets.UTF_8));
            buffer.compact();
        }

    }
}
