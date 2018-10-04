package local.jcore;

/**
 * @author xiaoshuang.cui
 * @date 2018/9/28 下午8:27
 **/
public class ClassNewSeq {

    public static final Object STATIC_FINAL_DATA = newFinalData();

    public static Object STATIC_DATA = newStaticData();

    static {
        System.out.println("static block");
    }

    static {
        num = 0;
    }

    public static int num = 1;

    private static Object newFinalData() {
        System.out.println("STATIC_FINAL_DATA");
        return new Object();
    }

    private static Object newStaticData() {
        System.out.println("STATIC_DATA");
        return new Object();
    }

    private Object normalFinalData = newNormalFinalData();

    private Object newNormalFinalData() {
        System.out.println("normal final");
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

    public static void justForClassUsage() {
        System.out.println("invoking justForClassUsage");
    }
}
