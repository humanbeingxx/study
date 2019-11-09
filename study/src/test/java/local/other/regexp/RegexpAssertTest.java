package local.other.regexp;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author cuixiaoshuang
 * @date 2019-07-22
 **/
public class RegexpAssertTest {

    @Test
    public void testAddComma() {
        String data = "12345678900";

        Pattern pattern = Pattern.compile("(?<=\\d)(?=\\d{3}($|,))");

        long startTime = System.currentTimeMillis();
        Matcher matcher = pattern.matcher(data);

        while (matcher.find()) {
            data = matcher.replaceAll(",");
            matcher = pattern.matcher(data);
        }

        System.out.println(System.currentTimeMillis() - startTime);
        System.out.println(data);
    }
}
