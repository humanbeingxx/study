package local.hystrix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import rx.Observable;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by pc on 2017/11/16.
 */
public class RollingWindowTest {

    private static final Logger logger = LoggerFactory.getLogger(RollingWindowTest.class);

    public static final Func2<Integer, Integer, Integer> INTEGER_SUM =
            (integer, integer2) -> integer + integer2;

    public static final Func1<Observable<Integer>, Observable<Integer>> WINDOW_SUM =
            window -> window.scan(0, INTEGER_SUM).skip(3);

    public static final Func1<Observable<Integer>, Observable<Integer>> INNER_BUCKET_SUM =
            integerObservable -> integerObservable.reduce(0, INTEGER_SUM);

    @Test
    public void test() throws InterruptedException {
        int bucketSize = 3;
        int windowSize = 3;

        PublishSubject<Integer> publishSubject = PublishSubject.create();
        SerializedSubject<Integer, Integer> serializedSubject = publishSubject.toSerialized();

        serializedSubject
                .window(bucketSize, TimeUnit.SECONDS)
                .flatMap(INNER_BUCKET_SUM)
                .window(windowSize, 3)
                .flatMap(WINDOW_SUM)
                .subscribe((Integer integer) -> System.out.println("\n" + Thread.currentThread().getName() + " call " + integer));

        Random random = new Random();

        int bucketStart = 0;
        for (int i = 0; i < 50; i++) {
            if (bucketStart < bucketSize) {
                bucketStart++;
            } else {
                bucketStart = 1;
                System.out.println();
            }
            int num = random.nextInt(5);
            serializedSubject.onNext(num);
            System.out.print(num + " ");
            Thread.sleep(1000);
        }
    }
}
