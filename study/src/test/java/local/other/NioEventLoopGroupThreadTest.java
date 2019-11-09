package local.other;

import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.util.concurrent.EventExecutor;
import org.testng.annotations.Test;

import java.util.Set;

/**
 * @author cuixiaoshuang
 * @date 2019-07-22
 **/
public class NioEventLoopGroupThreadTest {

    @Test
    public void test() {
        NioEventLoopGroup group = new NioEventLoopGroup(1);
        Set<EventExecutor> children = group.children();
        NioEventLoop eventLoop = (NioEventLoop) children.stream().findFirst().get();
        eventLoop.execute(() -> System.out.println("run a task"));
        System.out.println(eventLoop.inEventLoop());
    }
}
