package local.address.filter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author cuixiaoshuang
 * @date 2019-11-19
 **/
public class InvalidCharFilter implements CharacterFilter {

    private final static Pattern PATTERN = Pattern.compile("[^\\w^\\u4E00-\\u9FA5]+");

    @Override
    public String filter(String origin) {
        Matcher matcher = PATTERN.matcher(origin);
        if (matcher.find()) {
            return matcher.replaceAll("");
        } else {
            return origin;
        }
    }
}
