package local.design.state;

/**
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
