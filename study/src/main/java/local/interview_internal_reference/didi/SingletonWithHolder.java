package local.interview_internal_reference.didi;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/7/7 3:12
 */
public class SingletonWithHolder {


    private SingletonWithHolder() {
    }

    static class Holder {
        static SingletonWithHolder singleton = new SingletonWithHolder();
    }

    public static SingletonWithHolder getSingleton() {
        return Holder.singleton;
    }
}
