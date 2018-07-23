package local.design.factory;

import local.design.factory.cook.abs.JiaoZiMaker;
import local.design.factory.cook.abs.NoodleMaker;
import local.design.factory.cook.common.JiaoziCook;
import local.design.factory.cook.common.NoodleCook;
import local.design.factory.food.WheatenFood;
import org.junit.Test;

/**
 * Copyright © 2018 QUNAR.COM. All rights reserved.
 *
 * @author xiaoshuang.cui
 * @date 2018/7/23 下午9:09
 **/
public class Customer {

    @Test
    public void testCommonCook() {
        WheatenFood noodle = new NoodleCook().make();
        WheatenFood jiaozi = new JiaoziCook().make();

        System.out.println(noodle.taste());
        System.out.println(jiaozi.taste());
    }


    @Test
    public void testAbsFactory() {
        final WheatenFood soupJiaozi = new JiaoZiMaker().make("soup");
        final WheatenFood friedNoodle = new NoodleMaker().make("fried");

        System.out.println(soupJiaozi.taste());
        System.out.println(friedNoodle.taste());
    }
}
