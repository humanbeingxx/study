package local.rxjava;

import org.testng.annotations.Test;
import rx.Observer;
import rx.subjects.AsyncSubject;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;
import rx.subjects.ReplaySubject;

/**
 * Created by pc on 2017/11/16.
 */
public class RxSubjectTest {

    private Observer<String> simpleObserver() {
        return new Observer<String>() {
            @Override
            public void onCompleted() {
                System.out.println("Observer completed");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println("observer onNext " + s);
            }
        };
    }

    @Test
    public void testCreateAsyncSubject() throws Exception {
        AsyncSubject<String> asyncSubject = RxSubject.createAsyncSubject();
        asyncSubject.subscribe(simpleObserver());
        asyncSubject.onCompleted();
    }

    @Test
    public void testCreateBehaviourSubject() throws Exception {
        BehaviorSubject<String> behaviourSubject = RxSubject.createBehaviourSubject();
        behaviourSubject.subscribe(simpleObserver());
        behaviourSubject.onNext("step4");
        behaviourSubject.onNext("step5");
        behaviourSubject.onNext("step6");
        behaviourSubject.onCompleted();
    }

    @Test
    public void testCreatePublishSubject() throws Exception {
        PublishSubject<String> publishSubject = RxSubject.createPublishSubject();
        publishSubject.subscribe(simpleObserver());
        publishSubject.onNext("step4");
        publishSubject.onNext("step5");
        publishSubject.onNext("step6");
        publishSubject.onCompleted();
    }

    @Test
    public void testCreateReplaySubject() throws Exception {
        ReplaySubject<String> replaySubject = RxSubject.createReplaySubject();
        replaySubject.subscribe(simpleObserver());
        replaySubject.onNext("step4");
        replaySubject.onNext("step5");
        replaySubject.onNext("step6");
        replaySubject.onCompleted();
    }
}