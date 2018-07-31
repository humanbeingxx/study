package local.design.state;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author xiaoshuang.cui
 * @date 2018/7/3 下午7:56
 **/
public class LiftTest {

    @Test
    public void test() {
        final LiftContext liftContext = new LiftContext();
        Assert.assertEquals(LiftContext.STOP, liftContext.getLiftState());

        liftContext.close();
        liftContext.run();
        liftContext.stop();
        liftContext.open();
    }
}
