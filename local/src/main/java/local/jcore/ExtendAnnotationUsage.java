package local.jcore;

import javax.annotation.Resource;

/**
 * @author xiaoshuang.cui
 */
public class ExtendAnnotationUsage extends BaseAnnotationUsage {

    @Override
    @Resource
    public void func() {
        System.out.println("func in Extend");
    }
}
