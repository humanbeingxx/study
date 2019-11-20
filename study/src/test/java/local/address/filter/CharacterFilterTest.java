package local.address.filter;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2019-11-19
 **/
public class CharacterFilterTest {

    @Test
    public void testInvalid() {
        InvalidCharFilter filter = new InvalidCharFilter();
        System.out.println(filter.filter("a#B$c 58中文 吃飯 🍚"));
        System.out.println(filter.filter("为什么没有(ꐚꌒꑿꆺ)(ꐚꌒꑿꆺ)这名字特殊不？@￥￥￥ 为什么没有(ꐚꌒꑿꆺ)(ꐚꌒꑿꆺ)这名字特 "));
    }

    @Test
    public void testNumberFilter() {
        NumberFilter filter = new NumberFilter();
        System.out.println(filter.filter("22号院"));
        System.out.println(filter.filter("和平里五区小区"));
    }

    @Test
    public void testSCFilter() {
        SimpleChineseCharacterFilter filter = new SimpleChineseCharacterFilter();
        System.out.println(filter.filter("壹佰贰拾叁"));
        System.out.println(filter.filter("奮藍小區"));
    }
}