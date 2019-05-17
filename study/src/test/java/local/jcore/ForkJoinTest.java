package local.jcore;

import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * @date 2019-04-17
 **/
public class ForkJoinTest {

    class MyTask extends RecursiveTask<Integer> {

        private int begin;
        private int end;

        public MyTask(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            //TODO
            return 0;
        }
    }

    @Test
    public void testUse() throws ExecutionException, InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Integer> task = pool.submit(new MyTask(1, 10));
        Integer result = task.get();
        System.out.println(result);
    }

    @Test
    public void testJdkUser() {
        Lists.newArrayList(1, 2, 3, 4, 5).parallelStream().forEach(System.out::println);
    }
}
