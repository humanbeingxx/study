package local.design.factory.food;

/**
 * Copyright © 2018 QUNAR.COM. All rights reserved.
 *
 * @author xiaoshuang.cui
 * @date 2018/7/23 下午9:20
 **/
public class StyledNoodle extends Noodle {

    private CookStyle cookStyle;

    public void setCookStyle(CookStyle cookStyle) {
        this.cookStyle = cookStyle;
    }

    @Override
    public String taste() {
        return super.taste() + cookStyle.style();
    }
}
