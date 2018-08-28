package local.jcore.clh;

/**

 *
 * @author xiaoshuang.cui
 * @date 2018/8/27 下午2:51
 **/
public class CLHNode {

    private volatile boolean isLocked = true;

    public void unlock() {
        isLocked = false;
    }

    public boolean isLocked() {
        return isLocked;
    }
}
