package local.jcore;

/**
 * @author xiaoshuang.cui
 * @date 2018/9/28 下午8:27
 **/
public class ClassNewSeq {

    public static final Object STATIC_FINAL_DATA = newFinalData();

    public static final Object STATIC_DATA = newStaticData();

    static {
        System.out.println("static block");
    }

    private static Object newFinalData() {
        System.out.println("STATIC_FINAL_DATA");
        return new Object();
    }

    private static Object newStaticData() {
        System.out.println("STATIC_DATA");
        return new Object();
    }

    private Object normalData = newNormalData();

    private Object newNormalData() {
        System.out.println("normal");
        return new Object();
    }

    {
        System.out.println("normal block");
    }


    public ClassNewSeq() {
        System.out.println("construct");
    }
}
