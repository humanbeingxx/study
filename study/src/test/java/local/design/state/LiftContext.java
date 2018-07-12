package local.design.state;

/**
 * Copyright © 2018 QUNAR.COM. All rights reserved.
 *
 * @author xiaoshuang.cui
 * @date 2018/7/3 下午7:40
 **/
public class LiftContext {

    public final static ILiftState OPEN = new OpenLiftState();
    public final static ILiftState CLOSE = new CloseLiftState();
    public final static ILiftState RUNNING = new RunningLiftState();
    public final static ILiftState STOP = new StopLiftState();

    private ILiftState liftState;

    public LiftContext() {
        this.liftState = STOP;
        STOP.setContext(this);
    }

    public ILiftState getLiftState() {
        return liftState;
    }

    protected void setLiftState(ILiftState liftState) {
        this.liftState = liftState;
        liftState.setContext(this);
    }

    public void open() {
        liftState.open();
    }

    public void close() {
        liftState.close();
    }

    public void run() {
        liftState.run();
    }

    public void stop() {
        liftState.stop();
    }
}
