package local.algorithm.leetcode.lcci;

import org.testng.annotations.Test;

import java.util.List;

public class GetValidT9WordsTest {

    @Test
    public void testGetValidT9Words1() {
        List<String> result = new GetValidT9Words().getValidT9Words("8733", new String[]{"tree", "used"});
        System.out.println(result);
    }

    @Test
    public void testGetValidT9Words2() {
        List<String> result = new GetValidT9Words().getValidT9Words("2", new String[]{"a", "b", "c", "d"});
        System.out.println(result);
    }
}