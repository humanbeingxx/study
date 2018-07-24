package local.design.singleton;

import org.junit.Test;

/**
 *
 * @author xiaoshuang.cui
 * @date 2018/7/24 下午3:19
 **/
public class InstanceHolderTest {

    @Test
    public void test() {
        final InstanceHolder instance = InstanceHolder.getInstance();
        System.out.println(instance);
    }
}
