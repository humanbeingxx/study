package local.design.factory.cook.abs;

import local.design.factory.food.CookStyle;
import local.design.factory.food.StyledNoodle;
import local.design.factory.food.WheatenFood;

/**
 * @author xiaoshuang.cui
 * @date 2018/7/23 下午9:41
 **/
public class NoodleMaker implements AbstractWheatenFoodMaker {
    @Override
    public WheatenFood make(String style) {
        CookStyle cookStyle = new CookStyleDesigner().getStyle(style);
        StyledNoodle noodle = new StyledNoodle();
        noodle.setCookStyle(cookStyle);
        return noodle;
    }
}
