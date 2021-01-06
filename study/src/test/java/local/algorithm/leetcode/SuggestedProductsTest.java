package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.List;

public class SuggestedProductsTest {

    @Test
    public void testSuggestedProducts1() {
        List<List<String>> result = new SuggestedProducts().suggestedProducts(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouse");
        result.forEach(System.out::println);
    }

    @Test
    public void testSuggestedProducts2() {
        List<List<String>> result = new SuggestedProducts().suggestedProducts(new String[]{"havana"}, "havana");
        result.forEach(System.out::println);
    }

    @Test
    public void testSuggestedProducts3() {
        List<List<String>> result = new SuggestedProducts().suggestedProducts(new String[]{"bags", "baggage", "banner", "box", "cloths"}, "bags");
        result.forEach(System.out::println);
    }

    @Test
    public void testSuggestedProducts4() {
        List<List<String>> result = new SuggestedProducts().suggestedProducts(new String[]{"bags", "baggage", "banner", "box", "cloths"}, "xxbag");
        result.forEach(System.out::println);
    }
}