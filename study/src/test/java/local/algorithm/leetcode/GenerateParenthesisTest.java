package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2020-02-06
 **/
public class GenerateParenthesisTest {

    @Test
    public void testGenerateParenthesis1() {
        List<String> result = new GenerateParenthesis().generateParenthesis(1);
        result.forEach(System.out::println);
    }

    @Test
    public void testGenerateParenthesis3() {
        List<String> result = new GenerateParenthesis().generateParenthesis(3);
        result.forEach(System.out::println);
    }

    @Test
    public void testGenerateParenthesis0() {
        List<String> result = new GenerateParenthesis().generateParenthesis(0);
        result.forEach(System.out::println);
    }
}