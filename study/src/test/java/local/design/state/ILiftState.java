package local.design.state;

/**
 * Copyright © 2018 QUNAR.COM. All rights reserved.
 *
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
