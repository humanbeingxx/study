package local.interview_internal_reference.didi;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/7/7 3:17
 */
public class SingletonWithDoubleCheck {

    private static volatile SingletonWithDoubleCheck singleton;

    private SingletonWithDoubleCheck() {
    }

    public SingletonWithDoubleCheck getSingleton() {
        if (singleton == null) {
            synchronized (SingletonWithDoubleCheck.class) {
                if (singleton == null) {
                    singleton = new SingletonWithDoubleCheck();
                }
            }
        }
        return singleton;
    }
}
