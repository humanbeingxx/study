package local.design.state;

/**
 * @author xiaoshuang.cui
 * @date 2018/7/3 下午7:39
 **/
public interface ILiftState {

    void open();

    void close();

    void run();

    void stop();

    void setContext(LiftContext liftContext);
}
