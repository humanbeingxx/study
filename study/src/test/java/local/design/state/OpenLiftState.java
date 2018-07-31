package local.design.state;

/**
 * @author xiaoshuang.cui
 * @date 2018/7/3 下午7:47
 **/
public class OpenLiftState extends AbstractLiftState {

    @Override
    public void open() {
        System.out.println("opening");
    }

    @Override
    public void close() {
        this.liftContext.setLiftState(LiftContext.CLOSE);
        this.liftContext.close();
    }

    @Override
    public void run() {
        System.out.println("cannot close");
    }

    @Override
    public void stop() {
        System.out.println("cannot stop");
    }
}
