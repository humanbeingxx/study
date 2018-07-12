package local.design.state;

/**
 * Copyright © 2018 QUNAR.COM. All rights reserved.
 *
 * @author xiaoshuang.cui
 * @date 2018/7/3 下午7:41
 **/
public abstract class AbstractLiftState implements ILiftState {

    protected LiftContext liftContext;

    @Override
    public void setContext(LiftContext liftContext) {
        this.liftContext = liftContext;
    }
}
