package local.design.singleton;

/**
 *
 * @author xiaoshuang.cui
 * @date 2018/7/24 下午3:06
 **/
public class DoubleCheck {

    private String value1;
    private String value2;

    private volatile static DoubleCheck ourInstance;

    public static DoubleCheck getInstance() {
        if (ourInstance != null) {
            return ourInstance;
        }

        synchronized (DoubleCheck.class) {
            if (ourInstance != null) {
                return ourInstance;
            }
            ourInstance = new DoubleCheck();
            return ourInstance;
        }
    }

    private DoubleCheck() {
        System.out.println("creating......");
        value1 = "this is value1";
        value2 = "this is value2";
    }

    @Override
    public String toString() {
        return "DoubleCheck{" +
                "value1='" + value1 + '\'' +
                ", value2='" + value2 + '\'' +
                '}';
    }
}
