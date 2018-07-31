package local.design.singleton;

/**
 * @author xiaoshuang.cui
 * @date 2018/7/24 下午3:16
 **/
public class InstanceHolder {

    private static class Holder {
        static InstanceHolder instanceHolder = new InstanceHolder();
    }

    public static InstanceHolder getInstance() {
        return Holder.instanceHolder;
    }

    private InstanceHolder() {
        System.out.println("creating");
    }
}
