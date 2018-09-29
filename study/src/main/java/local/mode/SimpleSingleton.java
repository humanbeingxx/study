package local.mode;

/**
 * @author xiaoshuang.cui
 * @date 2018/9/27 下午5:48
 **/
public class SimpleSingleton {
    private static volatile SimpleSingleton ourInstance;

    private SimpleSingleton() {
    }

    public static SimpleSingleton getInstance() {
        if (ourInstance != null) {
            return ourInstance;
        }
        synchronized (SimpleSingleton.class) {
            if (ourInstance != null) {
                return ourInstance;
            } else {
                ourInstance = new SimpleSingleton();
                return ourInstance;
            }
        }
    }

}
