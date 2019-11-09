package local.nio;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2019-06-14
 **/
public class NettyTimeTest {

    @Test
    public void testBind() throws Exception {
        new NettyTimeClient().connect(9999);
    }

    @Test
    public void testObject() throws Exception {
        new NettyObjectTimeClient().connect(9998);
    }

    @Test
    public void testProtobuf() throws Exception {
        new NettyProtobufTimeClient().connect(9997);
    }
}