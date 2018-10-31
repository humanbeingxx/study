package local.before.d1101;

/**
 * @author xiaoshuang.cui
 * @date 2018/10/31 下午5:29
 **/
public class Single1 {
    private static final Single1 SINGLETON = new Single1();

    public static Single1 getSINGLETON() {
        return SINGLETON;
    }

    private Single1() {
        System.out.println("init Single1");
    }
}

