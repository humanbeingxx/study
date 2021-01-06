package local.interview_internal_reference;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class FirstBiggerNodeTest {

    @Test
    public void testFindFirstBiggerNodes1() {
        List<Integer> nodes = Lists.newArrayList(1, 2, 3, 4, 5);
        List<Integer> result = new FirstBiggerNode().findFirstBiggerNodes(nodes);
        assertEquals(result, Lists.newArrayList(2, 3, 4, 5, null));
    }

    @Test
    public void testFindFirstBiggerNodes2() {
        List<Integer> nodes = Lists.newArrayList(1, 3, 2, 5, 4);
        List<Integer> result = new FirstBiggerNode().findFirstBiggerNodes(nodes);
        assertEquals(result, Lists.newArrayList(3, 5, 5, null, null));
    }

    @Test
    public void testFindFirstBiggerNodes3() {
        List<Integer> nodes = Lists.newArrayList(5, 4, 3, 2, 1);
        List<Integer> result = new FirstBiggerNode().findFirstBiggerNodes(nodes);
        assertEquals(result, Lists.newArrayList(null, null, null, null, null));
    }

    @Test
    public void testFindFirstBiggerNodes4() {
        List<Integer> nodes = Lists.newArrayList(5);
        List<Integer> result = new FirstBiggerNode().findFirstBiggerNodes(nodes);
        assertNull(result.get(0));
    }

    @Test
    public void testFindFirstBiggerNodes5() {
        List<Integer> nodes = Lists.newArrayList(1, 1, 1, 1, 1);
        List<Integer> result = new FirstBiggerNode().findFirstBiggerNodes(nodes);
        assertEquals(result, Lists.newArrayList(null, null, null, null, null));
    }
}