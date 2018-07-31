package local.design.state;

/**
 * @author xiaoshuang.cui
 * @date 2018/7/3 下午7:53
 **/
public class StopLiftState extends AbstractLiftState {

    @Override
    public void open() {
        this.liftContext.setLiftState(LiftContext.OPEN);
        this.liftContext.open();
    }

    @Override
    public void close() {
        this.liftContext.setLiftState(LiftContext.CLOSE);
        this.liftContext.close();
    }

    @Override
    public void run() {
        this.liftContext.setLiftState(LiftContext.RUNNING);
        this.liftContext.run();
    }

    @Override
    public void stop() {
        System.out.println("stopping");
    }
}
