package local.algorithm.leetcode.lcci;

import org.testng.annotations.Test;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/21 20:15
 */
public class SortedStackTest {

    @Test
    public void test() {
        SortedStack stack = new SortedStack();
        stack.push(1);
        stack.push(2);
        int peek = stack.peek();
        System.out.println(peek);
    }
}