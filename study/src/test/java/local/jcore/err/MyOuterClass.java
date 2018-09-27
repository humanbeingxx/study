package local.jcore.err;

/**
 * @author xiaoshuang.cui
 * @date 2018/9/26 下午8:31
 **/
public class MyOuterClass {

    public static MyClassContainer getMyClassContainer(){
        throw new RuntimeException();
    }
}
