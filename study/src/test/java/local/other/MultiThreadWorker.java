package local.other;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @date : 2019-02-18
 **/
public class MultiThreadWorker<R> {
    private static Logger logger = LoggerFactory.getLogger(MultiThreadWorker.class);

    private ExecutorService pool = Executors.newSingleThreadExecutor();

    public List<R> work(List<Callable<R>> jobs) {
        try {
            List<R> result = Lists.newArrayList();
            List<Future<R>> futures = Lists.newArrayList();

            for (Callable<R> job : jobs) {
                futures.add(pool.submit(job));
            }

            for (Future<R> future : futures) {
                result.add(future.get());
            }
            pool.shutdown();
            return result;
        } catch (Exception e) {
            logger.error("MultiThreadWorker执行异常", e);
            throw new RuntimeException("MultiThreadWorker执行异常", e);
        }
    }

    @Test
    public void test() {
        MultiThreadWorker multiThreadWorker = new MultiThreadWorker();
        Callable<Object> callable1 = () -> "from 1";
        Callable<Object> callable2 = () -> "from 2";
        List results = multiThreadWorker.work(Lists.newArrayList(callable1, callable2));
        System.out.println(results);
    }

    public static void main(String[] args) {
        MultiThreadWorker multiThreadWorker = new MultiThreadWorker();
        Callable<Object> callable1 = () -> "from 1";
        Callable<Object> callable2 = () -> "from 2";
        List results = multiThreadWorker.work(Lists.newArrayList(callable1, callable2));
        System.out.println(results);
    }
}