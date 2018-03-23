package local.rxjava;

import com.google.common.collect.Lists;
import org.junit.Test;
import rx.Observable;
import rx.Observer;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by pc on 2017/11/16.
 */
public class SimpleRXTest {


    @Test
    public void testCreate() throws Exception {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        Observable<String> observable = SimpleRX.create();
        threadPool.invokeAll(Lists.newArrayList(getCallable(observable), getCallable(observable), getCallable(observable)));
    }

    private Callable<Void> getCallable(Observable<String> observable) {
        return () -> {
            observable.subscribe(getObserver());
            return null;
        };
    }



    private Observer<String> getObserver() {
        return new Observer<String>() {
            @Override
            public void onCompleted() {
                System.out.println(Thread.currentThread().getName() + " completed");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(Thread.currentThread().getName() + " onNext " + s);
            }
        };
    }
}