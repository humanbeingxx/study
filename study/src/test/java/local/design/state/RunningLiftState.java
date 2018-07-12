package local.design.state;

/**
 * Copyright © 2018 QUNAR.COM. All rights reserved.
 *
 * @author xiaoshuang.cui
 * @date 2018/7/3 下午7:52
 **/
public class RunningLiftState extends AbstractLiftState {

    @Override
    public void open() {
        System.out.println("cannot open");
    }

    @Override
    public void close() {
        System.out.println("already close");
    }

    @Override
    public void run() {
        System.out.println("running");
    }

    @Override
    public void stop() {
        this.liftContext.setLiftState(LiftContext.STOP);
        this.liftContext.stop();
    }
}
