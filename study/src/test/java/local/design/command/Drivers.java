package local.design.command;

import org.apache.commons.lang3.StringUtils;

/**
 * @author xiaoshuang.cui
 * @date 2018/7/24 下午4:04
 **/
public class Drivers {

    private final static String PACKAGE = "local.design.command";

    public static Driver forName(String name) {
        String fixedName = StringUtils.capitalize(StringUtils.lowerCase(name));
        String className = PACKAGE + "." + fixedName + "Driver";
        try {
            final Class<?> aClass = Class.forName(className);
            return (Driver) aClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("unsupported driver " + className, e);
        }
    }
}
