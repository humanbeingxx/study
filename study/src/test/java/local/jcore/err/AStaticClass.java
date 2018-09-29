package local.jcore.err;

/**
 * @author xiaoshuang.cui
 * @date 2018/9/29 下午7:35
 **/
public class AStaticClass {

    public static Object A_STATIC_OBJECT = getObject();

    private static Object getObject() {
        throw new RuntimeException();
    }
}
