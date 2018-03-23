package local.rxjava;

import com.google.common.collect.Lists;
import rx.Observable;
import rx.Observer;
import rx.functions.Action3;
import rx.functions.Func0;
import rx.functions.Func3;
import rx.observables.AsyncOnSubscribe;

/**
 * @author pc
 * @date 2017/11/16
 */
public class SimpleRX {

    public static Observable<String> create() {
        return Observable.create(AsyncOnSubscribe.createStateful(
                new Func0<Integer>() {
                    @Override
                    public Integer call() {
                        return 10;
                    }
                },
                new Func3<Integer, Long, Observer<Observable<? extends String>>, Integer>() {
                    @Override
                    public Integer call(Integer count, Long aLong, Observer<Observable<? extends String>> observer) {
                        if (count <= 0) {
                            observer.onCompleted();
                            return -1;
                        }
                        observer.onNext(Observable.from(Lists.newArrayList("test" + count)));
                        return count - 1;
                    }
                }
        ));
    }
}
