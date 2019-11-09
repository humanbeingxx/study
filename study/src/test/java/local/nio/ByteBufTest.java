package local.nio;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2019-06-20
 **/
public class ByteBufTest {

    @Test
    public void compareReuseAndMalloc() {
        ByteBuf buffer = Unpooled.buffer(256);
        byte[] data = "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111".getBytes();

        //discard
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            buffer.writeBytes(data);
            buffer.readBytes(256);
            buffer.discardReadBytes();
        }
        System.out.println(System.currentTimeMillis() - startTime);
        System.out.println(buffer.capacity());
        buffer.clear();
        System.out.println(buffer.capacity());
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            buffer.writeBytes(data);
            buffer.readBytes(256);
        }
        System.out.println(System.currentTimeMillis() - startTime);
        System.out.println(buffer.capacity());
    }

    @Test
    public void testMarkAndReset() {
        ByteBuf buffer = Unpooled.buffer(256);
        buffer.writeInt(123);
        buffer.writeInt(456);
        System.out.println(buffer.readInt());
        System.out.println(buffer.readInt());

        buffer.clear();
        buffer.writeInt(123);
        buffer.writeInt(456);
        buffer.markReaderIndex();
        System.out.println(buffer.readInt());
        buffer.resetReaderIndex();
        System.out.println(buffer.readInt());
    }
}
