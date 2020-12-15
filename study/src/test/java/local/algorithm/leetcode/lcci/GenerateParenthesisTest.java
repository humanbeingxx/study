package local.algorithm.leetcode.lcci;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/20 18:15
 */
public class GenerateParenthesisTest {

    @Test
    public void testGenerateParenthesis0() {
        List<String> result = new GenerateParenthesis().generateParenthesis(0);
        System.out.println(result);
    }

    @Test
    public void testGenerateParenthesis1() {
        List<String> result = new GenerateParenthesis().generateParenthesis(1);
        System.out.println(result);
    }

    @Test
    public void testGenerateParenthesis2() {
        List<String> result = new GenerateParenthesis().generateParenthesis(2);
        System.out.println(result);
    }

    @Test
    public void testGenerateParenthesis10() {
        List<String> result = new GenerateParenthesis().generateParenthesis(10);
        System.out.println(result);
    }
}