package local.gof;

public class SingletonWithHolder {

    private static class Holder {
        static SingletonWithHolder singleton = new SingletonWithHolder();
    }

    private SingletonWithHolder() {
    }

    public static SingletonWithHolder getInstance() {
        return Holder.singleton;
    }
}
