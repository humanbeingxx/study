package local.jcore.err;

/**
 * @author xiaoshuang.cui
 * @date 2018/9/26 下午8:34
 **/
public class MyClassUser {

    public static String name = "123";

    private static MyClass myObj = MyOuterClass.getMyClassContainer().getMyClass();

    public static void use() {
        myObj.getName();
    }

}
