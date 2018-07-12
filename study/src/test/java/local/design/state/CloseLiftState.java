package local.design.state;

/**
 *
 * @author xiaoshuang.cui
 * @date 2018/7/3 下午7:50
 **/
public class CloseLiftState extends AbstractLiftState {

    @Override
    public void open() {
        this.liftContext.setLiftState(LiftContext.OPEN);
        this.liftContext.close();
    }

    @Override
    public void close() {
        System.out.println("closing");
    }

    @Override
    public void run() {
        this.liftContext.setLiftState(LiftContext.RUNNING);
        this.liftContext.run();
    }

    @Override
    public void stop() {
        this.liftContext.setLiftState(LiftContext.STOP);
        this.liftContext.stop();
    }
}
