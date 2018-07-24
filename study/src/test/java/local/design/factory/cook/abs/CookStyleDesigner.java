package local.design.factory.cook.abs;

import com.google.common.collect.Maps;
import local.design.factory.food.CookStyle;
import local.design.factory.food.FriedStyle;
import local.design.factory.food.SoupStyle;

import java.util.Map;

/**
 *
 * @author xiaoshuang.cui
 * @date 2018/7/23 下午10:04
 **/
public class CookStyleDesigner {

    private Map<String, CookStyle> styles;

    public CookStyleDesigner() {
        styles = Maps.newHashMap();
        styles.put("fried", new FriedStyle());
        styles.put("soup", new SoupStyle());
    }

    public CookStyle getStyle(String style) {
        final CookStyle cookStyle = styles.get(style);
        if (cookStyle == null) {
            return () -> "";
        }
        return cookStyle;
    }
}
