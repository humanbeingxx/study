package local.gof;

public class SingletonWithDoubleCheck {

    private static volatile SingletonWithDoubleCheck singleton;

    private SingletonWithDoubleCheck() {
    }

    public static SingletonWithDoubleCheck getInstance() {
        if (singleton != null) {
            return singleton;
        }
        synchronized (SingletonWithDoubleCheck.class) {
            if (singleton == null) {
                singleton = new SingletonWithDoubleCheck();
            }
            return singleton;
        }
    }
}
