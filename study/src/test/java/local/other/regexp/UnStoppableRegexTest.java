package local.other.regexp;

import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author cuixiaoshuang
 * @date 2019-07-12
 **/
public class UnStoppableRegexTest {

    @Test
    public void test() {
        Pattern pattern = Pattern.compile("^([^x]+)*$");

        String stoppable = "1234567890123456789012345678901234567890";
        Matcher matcher = pattern.matcher(stoppable);

        System.out.println(matcher.find());


        String unstoppable = "1234567890123456789012345678901234567890x";
        matcher = pattern.matcher(unstoppable);

        System.out.println(matcher.find());
    }
}
