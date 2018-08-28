package local.jcore.clh;

/**

 *
 * @author xiaoshuang.cui
 * @date 2018/8/27 下午2:51
 **/
public class CLHNode {

    private String name;

    private boolean isLocked;

    public CLHNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void lock() {
        isLocked = true;
    }

    public void unlock() {
        isLocked = false;
    }

    public boolean isLocked() {
        return isLocked;
    }
}
