package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class EvalRPNTest {

    @Test
    public void testEvalRPN1() {
        int result = new EvalRPN().evalRPN(new String[]{"2", "1", "+", "3", "*"});
        assertEquals(result, 9);
    }

    @Test
    public void testEvalRPN2() {
        int result = new EvalRPN().evalRPN(new String[]{"4", "13", "5", "/", "+"});
        assertEquals(result, 6);
    }

    @Test
    public void testEvalRPN3() {
        int result = new EvalRPN().evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"});
        assertEquals(result, 22);
    }
}