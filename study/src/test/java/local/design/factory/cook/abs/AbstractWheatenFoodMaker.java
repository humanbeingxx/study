package local.design.factory.cook.abs;

import local.design.factory.food.WheatenFood;

/**
 *
 * @author xiaoshuang.cui
 * @date 2018/7/23 下午9:36
 **/
public interface AbstractWheatenFoodMaker {

    WheatenFood make(String style);
}
