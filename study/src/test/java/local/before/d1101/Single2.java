package local.before.d1101;

/**
 * @author xiaoshuang.cui
 * @date 2018/10/31 下午5:30
 **/
public class Single2 {

    private static class Single2Holder {
        private static final Single2 SINGLETON = new Single2();

    }

    public static Single2 getSINGLETON() {
        return Single2Holder.SINGLETON;
    }

    private Single2() {
        System.out.println("init Single2");
    }
}