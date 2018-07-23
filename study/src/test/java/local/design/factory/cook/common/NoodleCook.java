package local.design.factory.cook.common;

import local.design.factory.cook.Cook;
import local.design.factory.food.Noodle;
import local.design.factory.food.WheatenFood;

/**
 * Copyright © 2018 QUNAR.COM. All rights reserved.
 *
 * @author xiaoshuang.cui
 * @date 2018/7/23 下午9:11
 **/
public class NoodleCook implements Cook {

    @Override
    public WheatenFood make() {
        return new Noodle();
    }
}
