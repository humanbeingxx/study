package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2019-12-19
 **/
public class MinStackTest {

    @Test
    public void test() {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        int min = minStack.getMin();
        Assert.assertEquals(min, 0);
        minStack.pop();
        int top = minStack.top();
        Assert.assertEquals(top, 1);
        min = minStack.getMin();
        Assert.assertEquals(min, 0);
    }
}