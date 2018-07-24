package local.design.factory.cook.abs;

import local.design.factory.food.CookStyle;
import local.design.factory.food.StyledJiaoZi;
import local.design.factory.food.WheatenFood;

/**
 *
 * @author xiaoshuang.cui
 * @date 2018/7/23 下午9:41
 **/
public class JiaoZiMaker implements AbstractWheatenFoodMaker {

    @Override
    public WheatenFood make(String style) {
        CookStyle cookStyle = new CookStyleDesigner().getStyle(style);
        StyledJiaoZi jiaoZi = new StyledJiaoZi();
        jiaoZi.setCookStyle(cookStyle);
        return jiaoZi;
    }
}
