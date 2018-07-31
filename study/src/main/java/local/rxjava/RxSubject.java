package local.rxjava;

import rx.subjects.AsyncSubject;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;
import rx.subjects.ReplaySubject;

/**
 * @author pc
 * @date 2017/11/16
 */
public class RxSubject {

    public static AsyncSubject<String> createAsyncSubject() {
        AsyncSubject<String> asyncSubject = AsyncSubject.create();
        asyncSubject.onNext("step1");
        asyncSubject.onNext("step2");
        asyncSubject.onNext("step3");
        asyncSubject.onNext("step4");
        asyncSubject.onNext("step5");
        return asyncSubject;
    }

    public static BehaviorSubject<String> createBehaviourSubject() {
        BehaviorSubject<String> behaviorSubject = BehaviorSubject.create();
        behaviorSubject.onNext("step1");
        behaviorSubject.onNext("step2");
        behaviorSubject.onNext("step3");
        return behaviorSubject;
    }

    public static PublishSubject<String> createPublishSubject() {
        PublishSubject<String> publishSubject = PublishSubject.create();
        publishSubject.onNext("step1");
        publishSubject.onNext("step2");
        publishSubject.onNext("step3");
        return publishSubject;
    }

    public static ReplaySubject<String> createReplaySubject() {
        ReplaySubject<String> replaySubject = ReplaySubject.create();
        replaySubject.onNext("step1");
        replaySubject.onNext("step2");
        replaySubject.onNext("step3");
        return replaySubject;
    }
}
