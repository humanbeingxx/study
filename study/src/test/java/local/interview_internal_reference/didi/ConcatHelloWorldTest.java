package local.interview_internal_reference.didi;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/7/8 0:17
 */
public class ConcatHelloWorldTest {

    @Test
    public void testCanConcat1() {
        boolean result = new ConcatHelloWorld().canConcat(new String[]{"hell", "well", "hello", "world"});
        assertTrue(result);
    }

    @Test
    public void testCanConcat2() {
        boolean result = new ConcatHelloWorld().canConcat(new String[]{"hell", "well", "helloo", "world"});
        assertFalse(result);
    }
}