package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NextGreaterElementIIITest {

    @Test
    public void testNextGreaterElement1() {
        int result = new NextGreaterElementIII().nextGreaterElement(13);
        assertEquals(result, 31);
    }

    @Test
    public void testNextGreaterElement2() {
        int result = new NextGreaterElementIII().nextGreaterElement(21);
        assertEquals(result, -1);
    }

    @Test
    public void testNextGreaterElement3() {
        int result = new NextGreaterElementIII().nextGreaterElement(24153);
        assertEquals(result, 24315);
    }

    @Test
    public void testNextGreaterElement4() {
        int result = new NextGreaterElementIII().nextGreaterElement(29876543);
        assertEquals(result, 32456789);
    }

    @Test
    public void testNextGreaterElement5() {
        int result = new NextGreaterElementIII().nextGreaterElement(230241);
        assertEquals(result, 230412);
    }
}