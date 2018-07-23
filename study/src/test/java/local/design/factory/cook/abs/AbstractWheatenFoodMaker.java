package local.design.factory.cook.abs;

import local.design.factory.food.WheatenFood;

/**
 * Copyright © 2018 QUNAR.COM. All rights reserved.
 *
 * @author xiaoshuang.cui
 * @date 2018/7/23 下午9:36
 **/
public interface AbstractWheatenFoodMaker {

    WheatenFood make(String style);
}
