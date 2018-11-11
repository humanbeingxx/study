package local.algorithm.timewheel;

/**
 * @author xiaoshuang.cui
 * @date 2018/9/25 下午10:06
 **/
public interface TimeWheel {

    void add(AbstractTimeWheelTask task);

    void start();
}
