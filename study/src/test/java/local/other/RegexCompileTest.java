package local.other;

import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xiaoshuang.cui
 * @date 2018/6/14 上午10:40
 **/
public class RegexCompileTest {

    @Test
    public void testCompile() {
        String value = "this is a <regex> test";
        long startTime = System.currentTimeMillis();
        Pattern pattern = Pattern.compile(".*<(.*?)>.*");
        for (int i = 0; i < 10000000; i++) {
            Matcher matcher = pattern.matcher(value);
            matcher.find();
//            System.out.println(matcher.group(1));
        }
        long endTime = System.currentTimeMillis() - startTime;
        System.out.println(endTime);

        for (int i = 0; i < 10000000; i++) {
            Pattern patternLocal = Pattern.compile(".*<(.*?)>.*");
            Matcher matcher = patternLocal.matcher(value);
            matcher.find();
//            System.out.println(matcher.group(1));
        }
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
