package local.other;

import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.ExecutorServiceFactory;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author cuixiaoshuang
 * @date 2019-07-22
 **/
public class NioEventLoopGroupThreadTest {

    @Test
    public void test() {
        NioEventLoopGroup group = new NioEventLoopGroup(1, new ExecutorServiceFactory() {
            @Override
            public ExecutorService newExecutorService(int parallelism) {
                return Executors.newFixedThreadPool(parallelism, new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r, "boss");
                        return thread;
                    }
                });
            }
        });
        Set<EventExecutor> children = group.children();
        NioEventLoop eventLoop = (NioEventLoop) children.stream().findFirst().get();
        eventLoop.execute(() -> System.out.println("run a task"));
        System.out.println(eventLoop.inEventLoop());
    }
}
