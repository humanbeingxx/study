package local.utils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author cuixiaoshuang
 * @date 2019-12-04
 **/
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelColumn {

    String columnName() default "";

    int order() default 0;
}
