package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.List;

public class CamelCaseMatchTest {

    @Test
    public void test() {
        String p = "FB";
        System.out.println(p.replaceAll("", "[a-z]"));
    }

    @Test
    public void testCamelMatch1() {
        List<Boolean> result = new CamelCaseMatch().camelMatch(new String[]{
                "FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"
        }, "FB");
        System.out.println(result);
    }

    @Test
    public void testCamelMatch2() {
        List<Boolean> result = new CamelCaseMatch().camelMatch(new String[]{
                "FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"
        }, "FoBaT");
        System.out.println(result);
    }

    @Test
    public void testCamelMatch2_1() {
        List<Boolean> result = new CamelCaseMatch().camelMatch2(new String[]{
                "FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"
        }, "FB");
        System.out.println(result);
    }

    @Test
    public void testCamelMatch2_2() {
        List<Boolean> result = new CamelCaseMatch().camelMatch2(new String[]{
                "FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"
        }, "FoBaT");
        System.out.println(result);
    }
}