package local.algorithm.leetcode;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LadderLengthTest {

    @Test
    public void testLadderLength1() {
        int result = new LadderLength().ladderLength("hit", "cog", Lists.newArrayList("hot","dot","dog","lot","log","cog"));
        assertEquals(result, 5);
    }

    @Test
    public void testLadderLength2() {
        int result = new LadderLength().ladderLength("hit", "cog", Lists.newArrayList("hot","dot","dog","lot","log"));
        assertEquals(result, 0);
    }

    @Test
    public void testLadderLength3() {
        int result = new LadderLength().ladderLength("hit", "cot", Lists.newArrayList("hot","dot","dog","lot","log", "cot"));
        assertEquals(result, 3);
    }
}