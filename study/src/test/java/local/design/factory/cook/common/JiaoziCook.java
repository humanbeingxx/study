package local.design.factory.cook.common;

import local.design.factory.cook.Cook;
import local.design.factory.food.JiaoZi;
import local.design.factory.food.WheatenFood;

/**
 * @author xiaoshuang.cui
 * @date 2018/7/23 下午9:15
 **/
public class JiaoziCook implements Cook {
    @Override
    public WheatenFood make() {
        return new JiaoZi();
    }
}
